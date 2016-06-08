name := """tweets_analyzer"""
version := "1.0-SNAPSHOT"
scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
//lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

//Repositories
resolvers += "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
resolvers +=  "Apache repo" at "https://repository.apache.org/content/repositories/releases"


libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

//Additional JSON processing libraries
libraryDependencies += "com.google.code.gson" % "gson" % "2.6.2"

//Kafka consumer
//libraryDependencies += "org.apache.kafka" % "kafka_2.9.2" % "0.8.1.1" exclude("javax.jms", "jms") exclude("com.sun.jdmk", "jmxtools") exclude("com.sun.jmx", "jmxri")
libraryDependencies += "org.apache.kafka" % "kafka_2.10" % "0.10.0.0" exclude("javax.jms", "jms") exclude("com.sun.jdmk", "jmxtools") exclude("com.sun.jmx", "jmxri")

// http://mvnrepository.com/artifact/org.scala-lang/scala-library
libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.7"

//EBEAN
//libraryDependencies += "org.avaje.ebeanorm" % "avaje-ebeanorm" % "7.1.1"
//libraryDependencies += "org.avaje" % "avaje-agentloader" % "2.1.2"
//libraryDependencies += "org.avaje.ebeanorm" % "avaje-ebeanorm-agent" % "4.x9.1"

fork in run := true

//This is necessary if you want to debug your unit tests
Keys.fork in (Test) := false

//To enable the injected routes generator specifically
routesGenerator := InjectedRoutesGenerator