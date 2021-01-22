package callFromHttp4s.main

import cats.effect.IO
import callFromHttp4s.http4s.HttpClientInstances.createClient
import io.circe.generic.auto._
import callFromHttp4s.model.Pet

object Main {

  private val client = createClient("http://petstore-demo-endpoint.execute-api.com/petstore/pets")

  def main(args: Array[String]): Unit = {
    getStudent.unsafeRunSync()
  }

  def getStudent: IO[Pet] = for {
    student <- client.get[Pet]()
    _ = println(student)
  } yield student

}
