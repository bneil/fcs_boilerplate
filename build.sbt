import sbt._

import scalariform.formatter.preferences._

name := "FCS Boilerplate"

organization := "com.neilconcepts"

version := "0.1.0-SNAPSHOT"

homepage := Some(url("https://neil-concepts.com"))

startYear := Some(2016)

/* scala versions and options */
scalaVersion := "2.11.8"

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation"
  , "-unchecked"
  , "-encoding", "UTF-8"
  , "-Xlint"
  , "-Yclosure-elim"
  , "-Yinline"
  , "-Xverify"
  , "-feature"
  , "-language:postfixOps"
  //,"-optimise"
)

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation", "-source", "1.7", "-target", "1.7")
javaOptions in Universal ++= Seq(
  "-J-server",
  "-J-Xms500m -Xmx1g",
  "-J-XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled",
  "-J-XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=68",
  "-J-XX:+ScavengeBeforeFullGC -XX:+CMSScavengeBeforeRemark",
  "-J-XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M"
)

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

fork := true

mainClass in Compile := Some("com.neilconcepts.Server")

/* dependencies */
libraryDependencies ++= Seq(
  // -- config
  "com.typesafe" % "config" % "1.3.0"
  // -- testing --
  , "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  // -- Logging --
  , "ch.qos.logback" % "logback-classic" % "1.1.3"
  , "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
  // -- Joda --
  , "joda-time" % "joda-time" % "2.7"
  // -- Finch --
  , "com.github.finagle" %% "finch-core" % "0.10.0"
  , "com.github.finagle" %% "finch-circe" % "0.10.0"
  // -- Shapeless --
  , "com.chuusai" %% "shapeless" % "2.3.0"
)

scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(IndentLocalDefs, true)
  .setPreference(IndentPackageBlocks, true)
  .setPreference(IndentSpaces, 2)
  .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)

