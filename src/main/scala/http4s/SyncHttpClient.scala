package http4s

import cats.effect.{ContextShift, IO, Resource}
import org.http4s.Method.GET
import org.http4s.{EntityDecoder, Request, Uri}
import org.http4s.client.Client

class SyncHttpClient(targetServer: String, clientResource: Resource[IO, Client[IO]])(implicit cs: ContextShift[IO]) extends HttpClient(targetServer, clientResource) {

  def get[A: io.circe.Decoder](): IO[A] = httpClient use { client =>
    import org.http4s.circe.CirceEntityDecoder._
    send(client)(Request[IO](GET, Uri.unsafeFromString(s"$targetServer")))
  }

  private def send[T](client: Client[IO])(request: Request[IO])(implicit d: EntityDecoder[IO, T]) =
    for {
      r <- client.expectOr[T](request)(response => IO.raiseError(new RuntimeException(s"http client fail with $response")))
    } yield r

}
