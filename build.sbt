scalaVersion := "3.2.2"

name := "hello-world-scala"
organization := "com.kinsta"
version := "1.0"

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.8.4"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.8.4"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.5.2"

enablePlugins(JavaAppPackaging)

executableScriptName := "main"
