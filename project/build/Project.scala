import sbt._

import com.twitter.sbt._

class Project(info: ProjectInfo) extends StandardProject(info) with SubversionPublisher {
  val specs = buildScalaVersion match {
    case "2.7.7" => "org.scala-tools.testing" % "specs" % "1.6.2.1"
    case _ => "org.scala-tools.testing" % "specs_2.8.1" % "1.6.6"
  }
  val configgy = buildScalaVersion match {
    case "2.7.7" => "net.lag" % "configgy" % "1.6.4"
    case _ => "net.lag" % "configgy" % "2.0.2"
  }

  override def disableCrossPaths = false
  override def subversionRepository = Some("http://svn.local.twitter.com/maven-public/")
}
