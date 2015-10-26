name := "typeclasses-and-implicits-exercises"

version := "0.0.0"

scalaVersion := "2.11.7"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",//para poder ver feature warnings al compilar
  "-language:postfixOps", //para cosas como '5 seconds'
  "-language:implicitConversions",
  "-language:existentials",
  "-language:higherKinds",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  //"-Ywarn-numeric-widen",
  //"-Ywarn-value-discard", // No muy buena idea combinar esto con akka
  "-Xfuture"
)

resolvers ++= Seq(
    "Sonatype Releases"   at "http://oss.sonatype.org/content/repositories/releases",
    "Sonatype Snapshots"  at "http://oss.sonatype.org/content/repositories/snapshots"
)

val scalazV = "7.1.0"

libraryDependencies ++= Seq(
  "joda-time"                 %   "joda-time"                     % "2.4",
  "org.joda"                  %   "joda-convert"                  % "1.6",
  "junit"                     %   "junit"                         % "4.10"    % "test",
  "org.scalatest"             %%  "scalatest"                     % "2.2.1"   % "test"
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.6.3")