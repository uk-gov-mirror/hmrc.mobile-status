import play.core.PlayVersion.current
import sbt._

object AppDependencies {

  private val play26Bootstrap    = "3.0.0"
  private val playHmrcApiVersion = "4.1.0-play-26"

  private val pegdownVersion       = "1.6.0"
  private val wireMockVersion      = "2.27.2"
  private val scalaTestVersion     = "3.0.8"
  private val scalaTestPlusVersion = "3.1.2"
  private val mockitoVersion       = "3.6.28"
  private val refinedVersion       = "0.9.19"

  val compile = Seq(
    "uk.gov.hmrc" %% "bootstrap-backend-play-26" % play26Bootstrap,
    "uk.gov.hmrc" %% "play-hmrc-api"             % playHmrcApiVersion,
    "eu.timepit"  %% "refined"                   % refinedVersion
  )

  val test = Seq(
    "org.scalatest"          %% "scalatest"          % scalaTestVersion     % "test, it",
    "com.typesafe.play"      %% "play-test"          % current              % "test",
    "org.pegdown"            % "pegdown"             % pegdownVersion       % "test, it",
    "org.mockito"            % "mockito-core"        % mockitoVersion       % "test,it",
    "com.github.tomakehurst" % "wiremock"            % wireMockVersion      % "it",
    "org.scalatestplus.play" %% "scalatestplus-play" % scalaTestPlusVersion % "test, it"
  )

}
