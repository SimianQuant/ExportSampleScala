def commonSettings(nameStr: String) = Seq(
  name := nameStr,
  organization := "com.simianquant.sample",
  version := Settings.versions.project,
  scalaVersion := Settings.versions.scala,
  scalacOptions ++= List(
    ("-Xlint:adapted-args,nullary-unit,inaccessible,nullary-override,infer-any,doc-detached,private-shadow," +
      "type-parameter-shadow,poly-implicit-overload,option-implicit,delayedinit-select,by-name-right-associative," +
      "package-object-classes,unsound-match,stars-align,constant"),
    "-Ywarn-unused:imports,patvars,privates,locals",
    "-opt:l:method",
    "-Ywarn-unused-import",
    "-deprecation",
    "-unchecked",
    "-explaintypes",
    "-encoding",
    "UTF-8",
    "-feature",
    "-Xlog-reflective-calls",
    "-Ywarn-inaccessible",
    "-Ywarn-infer-any",
    "-Ywarn-nullary-override",
    "-Ywarn-nullary-unit",
    "-Xfuture",
    "-Xelide-below",
    "INFO"
  ),
  parallelExecution in Test := true,
  fork := true,
  javaOptions ++= Seq(
    "-d64",
    "-XX:+HeapDumpOnOutOfMemoryError",
    "-XX:+UseG1GC",
    "-XX:+UseStringDeduplication",
    "-Xmx3072m")
)

lazy val sample = project
  .in(file("sample"))
  .settings(commonSettings("sample"))
  .settings(
    libraryDependencies ++= Seq(
      "com.simianquant" %% "mathbridge" % Settings.versions.mathbridge,
      "org.scalatest" %% "scalatest" % Settings.versions.scalatest % "test",
      "org.scalacheck" %% "scalacheck" % Settings.versions.scalacheck % "test"
    ),
    logBuffered in Test := true,
    testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")
  )

lazy val bench = project
  .in(file("bench"))
  .settings(commonSettings("bench"))
  .dependsOn(sample)
  .enablePlugins(JmhPlugin)

lazy val root = project
  .in(file("."))
  .settings(commonSettings("root"))
  .settings(
    publishArtifact in (Compile, packageBin) := false,
    publishArtifact in (Compile, packageDoc) := false,
    publishArtifact in (Compile, packageSrc) := false,
    publishArtifact in (Test, packageBin) := false,
    publishArtifact in (Test, packageDoc) := false,
    publishArtifact in (Test, packageSrc) := false
  )
