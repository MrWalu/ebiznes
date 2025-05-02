enablePlugins(PlayScala)

scalaVersion := "3.3.1"

name := "ProductApp"

version := "1.0"

libraryDependencies ++= Seq(
  guice,
  "org.playframework" %% "play" % "3.0.0"
)