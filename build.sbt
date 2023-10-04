scalaVersion := "2.13.8"

name := "hello-world-scala"
organization := "com.kinsta"
version := "1.0"

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.19"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.19"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.9"

enablePlugins(JavaAppPackaging)

executableScriptName := "main"
