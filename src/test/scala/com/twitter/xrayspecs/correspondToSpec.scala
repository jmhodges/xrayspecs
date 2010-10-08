package com.twitter.xrayspecs

import com.twitter.xrayspecs.TimeConversions._
import org.specs.mock.{ClassMocker, JMocker}
import org.specs.Specification

/**
 * This is so meta, using a matcher to test itself.
 */
object correspondToSpec extends Specification {
  "correspondTo" should {
    "match empty lists" in {
      Nil must correspondTo(Nil)
    }

    "match empty Seqs" in {
      Seq() must correspondTo(Nil)
    }

    "with default equality predicate" in {
      "match populated lists" in {
        List(1, 2, 3) must correspondTo(List(1, 2, 3))
      }

      "mix and match types" in {
        Seq(1, 2, 3) must correspondTo(List(1, 2, 3))
        List(1, 2, 3) must correspondTo(Seq(1, 2, 3))
      }

      "handle wrong sizes" in {
        Seq(1, 2, 3) must not(correspondTo(Seq(1, 2, 3, 4)))
        Seq(1, 2, 3, 4) must not(correspondTo(Seq(1, 2, 3)))
      }

      "handle non-corresponding" in {
        Seq(1, 2, 3) must not(correspondTo(Seq(1, 3, 2)))
      }
    }

    "with explicit predicate" in {
      def strMatch(a: String, b: String) = a.toLowerCase.trim == b.toLowerCase.trim

      "match corresponding" in {
        List("a", "b", "c") must correspondTo(List("A", " B ", "C"), strMatch)
      }

      "handle non-corresponding" in {
        List("a", "b", "c") must not(correspondTo(List("B", " A ", "C"), strMatch))
      }
    }
  }
}
