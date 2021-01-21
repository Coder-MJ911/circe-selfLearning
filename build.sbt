name := "circeLearning"

version := "0.1"

scalaVersion := "2.13.4"

val CirceVersion = "0.13.0"
val Http4sVersion = "0.21.8"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-core" % Http4sVersion,
  "org.http4s" %% "http4s-dsl" % Http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % Http4sVersion,
  "org.http4s" %% "http4s-circe" % Http4sVersion,
  "io.circe" %% "circe-core" % CirceVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s" %% "http4s-argonaut" % Http4sVersion
)