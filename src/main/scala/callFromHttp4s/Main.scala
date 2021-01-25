package callFromHttp4s

import callFromHttp4s.http4s.HttpClientInstances.createClient
import cats.effect.IO
import io.circe.generic.auto._

object Main {

  private val client = createClient("http://petstore-demo-endpoint.execute-api.com/petstore/pets")

  def main(args: Array[String]): Unit = {
    getStudent.unsafeRunSync()
  }

  def getStudent: IO[List[Pet]] = for {
    student <- client.get[List[Pet]]()
    _ = println(student)
  } yield student

}
