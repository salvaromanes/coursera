ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

lazy val root = (project in file("."))
  .settings(
    name := "coursera"
  )

libraryDependencies += "org.typelevel" %% "cats-core" % "2.9.0"