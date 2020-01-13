name := "slicker"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.1",
  "com.typesafe.slick" %% "slick-codegen" % "3.3.1",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.1",
  "mysql" % "mysql-connector-java" % "8.0.18",
  "org.slf4j" % "slf4j-nop" % "1.7.26"
)

lazy val schemaCodeGeneration = taskKey[Unit]("generate schema code")
schemaCodeGeneration := Def.taskDyn {
  val profile = "slick.jdbc.MySQLProfile"
  val jdbc = "com.mysql.cj.jdbc.Driver"
  val url = "jdbc:mysql://127.0.0.1:3306/rssp?serverTimezone=UTC"
  val sourceFolder = "./src/main/scala"
  val pkg = "com.slicker.entity"
  val user = "dbuser"
  val password = "dbpassword"

  Def.task {
    (runMain in Compile)
      .toTask(
        s" slick.codegen.SourceCodeGenerator $profile $jdbc $url $sourceFolder $pkg $user $password"
      )
      .value
  }
}.value
