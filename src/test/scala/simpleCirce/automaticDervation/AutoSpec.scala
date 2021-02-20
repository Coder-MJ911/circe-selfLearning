package simpleCirce.automaticDervation

import helpers.Specification
import simpleCirce.automaticDerivation.{Greeting, Person}
import io.circe.generic.auto._, io.circe.syntax._

class AutoSpec extends Specification{
  "automatic decode & encode" should {
    "" in {

      val greetJson = Greeting("Hey", Person("Chris"), 3).asJson
      val greeting = greetJson.as[Greeting]

      greeting.toOption shouldEqual Some(Greeting("Hey",Person("Chris"),3))

    }
  }

}
