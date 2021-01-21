package http4s

import cats.effect.{ContextShift, IO}
import org.http4s.client.blaze.BlazeClientBuilder

import scala.concurrent.ExecutionContext


object HttpClientInstances {

  def createClient(apiUrl: String): SyncHttpClient = {
    val ec = ExecutionContext.global
    implicit val sc: ContextShift[IO] = IO.contextShift(ec)
    new SyncHttpClient(apiUrl, BlazeClientBuilder[IO](ec).resource)
  }

}
