name := """tweets_analyzer"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

resolvers += "Maven" at "http://mvnrepository.com/artifact/org.apache.kafka/kafka_2.9.2"

//Additional JSON processing libraries
libraryDependencies += "com.google.code.gson" % "gson" % "2.6.2"
//Kafka consumer
//libraryDependencies += "org.apache.kafka" % "kafka_2.9.2" % "0.8.1.1"