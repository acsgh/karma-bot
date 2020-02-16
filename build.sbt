organization := "com.github.acsgh.mad.scala"
name := "karma-bot"
version := "0.1"
scalaVersion := "2.13.1"

import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

scalacOptions += "-feature"
scalacOptions += "-deprecation"

sonatypeProfileName := "com.github.acsgh"

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("+publishSigned"),
  releaseStepCommand("sonatypeBundleRelease"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)


releasePublishArtifactsAction := PgpKeys.publishSigned.value

libraryDependencies ++= Seq(
  "com.beachape" %% "enumeratum" % "1.5.13",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "org.slf4j" % "slf4j-api" % "1.7.21",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "org.scalacheck" %% "scalacheck" % "1.14.2" % Test,
  "org.pegdown" % "pegdown" % "1.4.2" % Test,
  "org.scalamock" %% "scalamock" % "4.4.0" % Test,
)

homepage := Some(url("https://github.com/acsgh/karma-bot"))

licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

publishTo := sonatypePublishToBundle.value

scmInfo := Some(
  ScmInfo(
    url("https://github.com/acsgh/karma-bot"),
    "scm:git:git@github.com:acsgh/karma-bot.git"
  )
)

developers := List(
  Developer("acsgh", "Alberto Crespo", "albertocresposanchez@gmail.com", url("https://github.com/acsgh"))
)


