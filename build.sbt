name := """tweets_analyzer"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

//Additional JSON processing libraries
libraryDependencies += "com.google.code.gson" % "gson" % "2.6.2"