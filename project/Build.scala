import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "weber-plays"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "org.mindrot" % "jbcrypt" % "0.3m",
    "play2-crud" % "play2-crud_2.10" % "0.5.0-SNAPSHOT"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
    resolvers += "release repository" at  "http://hakandilek.github.com/maven-repo/releases/",
    resolvers += "snapshot repository" at "http://hakandilek.github.com/maven-repo/snapshots/"
  )

}
