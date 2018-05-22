lazy val root = project.in(file("."))
  .settings(BuildSettings.commonSettings)
  .settings(
    BuildSettings.macroSettings ++ BuildSettings.noPublishSettings,
    description := "Snowplow Google BigQuery Loader",
    libraryDependencies ++= Seq(
      Dependencies.scioCore,
      Dependencies.directRunner,
      Dependencies.slf4j,
      Dependencies.decline,
      Dependencies.catsEffect,
      Dependencies.analyticsSdk,
      Dependencies.processingManifest,
      Dependencies.igluClient,
      Dependencies.igluCoreCirce,
      Dependencies.circe,
      Dependencies.circeJavaTime,

      Dependencies.specs2,
      Dependencies.scalaCheck
    )
  ).enablePlugins(PackPlugin)

lazy val repl = project.in(file("repl"))
  .settings(BuildSettings.commonSettings)
  .settings(
    BuildSettings.macroSettings ++ BuildSettings.noPublishSettings,
    description := "Scio REPL for bq-scio",
    libraryDependencies ++= Seq(Dependencies.scioRepl),
    mainClass in Compile := Some("com.spotify.scio.repl.ScioShell")
  ).dependsOn(root)