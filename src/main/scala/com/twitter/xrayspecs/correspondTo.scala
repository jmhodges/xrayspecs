package com.twitter.xrayspecs

import org.specs.matcher.Matcher

case object correspondTo {
  def apply[A](expected: Seq[A]): correspondTo[A, A] = correspondTo(expected, _ == _)
}

case class correspondTo[A, B](expected: Seq[B], p: (A, B) => Boolean) extends Matcher[Seq[A]]() {
  def apply(givenFn: => Seq[A]) = {
    val given = givenFn
    if (given.size != expected.size)
      (false, "", "size of Seq was "+given.size+", expecting "+expected.size)
    else {
      (0 until given.size).find(i => !p(given(i), expected(i))) match {
        case None => (true, "Seqs are equal", "")
        case Some(i) => (false, "", "Seqs are different at index "+i+", "+given(i)+" != "+expected(i))
      }
    }
  }
}
