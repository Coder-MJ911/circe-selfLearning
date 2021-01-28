package callFromHttp4s

import callFromHttp4s.http4s.HttpClientInstances.createClient
import cats.effect.IO
import io.circe.generic.auto._

object Main {

  private val client = createClient("http://petstore-demo-endpoint.execute-api.com/petstore/pets")

  def main(args: Array[String]): Unit = {
    getPet.unsafeRunSync()
  }

  def getPet: IO[List[Pet]] = for {
    pets <- client.get[List[Pet]]()
    _ = println(pets)
  } yield pets

}
