package callFromHttp4s.http4s

import cats.effect.{ContextShift, IO, Resource}
import org.http4s.circe.CirceEntityCodec._
import org.http4s.client.Client
import org.http4s.client.middleware.{RequestLogger, ResponseLogger}
import org.http4s.headers.`Content-Type`
import org.http4s.{MediaType, Method, Request, Uri}


abstract class HttpClient(targetServer: String, clientResource: Resource[IO, Client[IO]])(implicit cs: ContextShift[IO]) {

  protected val httpClient: Resource[IO, Client[IO]] = clientResource
    .map(RequestLogger.apply[IO](true, false))
    .map(ResponseLogger.apply[IO](true, false))

  protected def buildRequest[A: io.circe.Encoder](method: Method)(body : A): Request[IO] =
    Request[IO](method, Uri.unsafeFromString(s"$targetServer"))
      .withContentType(`Content-Type`(MediaType.application.json))
      .withEntity(body)
}
