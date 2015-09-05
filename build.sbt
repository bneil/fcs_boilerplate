scalaVersion := "2.11.7"

name := "quickstart"

version := "1.0"

resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )

incOptions := incOptions.value.withNameHashing(false)

libraryDependencies ++= Seq(
    "io.circe" %% "circe-core" % "0.1.1",
    "io.circe" %% "circe-generic" % "0.1.1",
    "io.circe" %% "circe-jawn" % "0.1.1",
    "com.chuusai" %% "shapeless" % "2.2.5",
    "com.twitter" %% "finagle-httpx" % "6.28.0"
  )
