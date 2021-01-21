package main

import cats.effect.IO
import http4s.HttpClientInstances.createClient
import io.circe.generic.auto._
import model.Student

object Main {

  private val client = createClient("./response.json")

  def main(args: Array[String]): Unit = {
    getStudent.unsafeRunSync()
  }

  def getStudent: IO[Student] = for {
    student <- client.get[Student]()
    _ = println(student)
  } yield student

}
