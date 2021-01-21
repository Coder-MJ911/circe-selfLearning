package http4s

import cats.effect.IO
import org.http4s.circe.CirceEntityCodec.circeEntityEncoder
import org.http4s.headers.`Content-Type`
import org.http4s.{MediaType, Method, Request, Uri}


abstract class HttpClient {

  def buildRequest[A: io.circe.Encoder](targetServer: String, method: Method)(body : A): Request[IO] =
    Request[IO](method, Uri.unsafeFromString(s"$targetServer"))
      .withContentType(`Content-Type`(MediaType.application.json))
      .withEntity(body)
}
