package forHttp4s

import callFromHttp4s.Pet
import callFromHttp4s.http4s.HttpClientInstances.createClient
import callFromHttp4s.http4s.SyncHttpClient
import cats.effect.IO
import helpers.Specification
import io.circe.generic.auto._

class Http4sCirceSpec extends Specification{
  "decode by http4s response" should {

    "decode" in {
      val client: SyncHttpClient = createClient("http://petstore-demo-endpoint.execute-api.com/petstore/pets")

      getPet(client).unsafeRunSync shouldEqual List(Pet(1,"dog",249.99), Pet(2,"cat",124.99), Pet(3,"fish",0.99))
    }

    def getPet(client: SyncHttpClient): IO[List[Pet]] = for {
      pets <- client.get[List[Pet]]()
      _ = println(pets)
    } yield pets
  }
}
