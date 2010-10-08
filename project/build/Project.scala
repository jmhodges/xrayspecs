import sbt._

import com.twitter.sbt._

class Project(info: ProjectInfo) extends StandardProject(info) {
  val specs = "org.scala-tools.testing" %% "specs" % "1.6.5"
  val vscaladoc = "org.scala-tools" % "vscaladoc" % "1.1-md-3"
  val twitterJson = "com.twitter" %% "json" % "2.1.4"
  val configgy = "net.lag" % "configgy" % "2.0.0"

  override def disableCrossPaths = false

  Credentials(Path.userHome / ".ivy2" / "credentials", log)
  val publishTo = "nexus" at "http://nexus.scala-tools.org/content/repositories/releases/"
}
