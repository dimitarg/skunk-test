import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets
import sbt.complete.DefaultParsers._


val SkunkVersion = "0.2.2"

val runTest = inputKey[Unit]("run test")

lazy val root = (project in file("."))
  .settings(
    Global / onChangedBuildSource := ReloadOnSourceChanges,
    scalaVersion := "2.13.6",
    libraryDependencies ++= Seq(
      "org.tpolecat" %% "skunk-core" % SkunkVersion
    ),
    runTest := {
      val n: Int = spaceDelimited("<arg>").parsed.head.toInt
      val range = 1 to n

      val codec = range.map(_ => "text").mkString(" ~ ")
      val args = range.map(_ => "_").mkString(" ~ ")
      val program = s"""
      import skunk._
      import skunk.implicits._
      import skunk.codec.all._

      object Test {
        (
          $codec
        ).map {
        case $args => ()
        }
      }
      """

      val f = (Compile / sourceDirectory).value / "scala" /  "Test.scala"
      
      IO.write(f, program)

      Seq(f)
  },
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    scalacOptions ++= Seq(
    "-Yprofile-trace",
    "trace.trace"
    )
  )
  
