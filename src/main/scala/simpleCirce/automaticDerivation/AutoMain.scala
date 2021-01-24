package simpleCirce.automaticDerivation

import io.circe.generic.auto._, io.circe.syntax._

object AutoMain {

  def main(args: Array[String]): Unit = {
    val greetJson = Greeting("Hey", Person("Chris"), 3).asJson
    val greeting = greetJson.as[Greeting]

    println("greeting = " + greeting.toOption)
  }
}
