package simpleCirce.automaticDervation

import helpers.Specification
import io.circe.generic.auto._
import io.circe.syntax._
import simpleCirce.{Greeting, Person}

class AutoSpec extends Specification{
  "automatic decode & encode" should {
    "" in {

      val greetJson = Greeting("Hey", Person("Chris"), 3).asJson
      val greeting = greetJson.as[Greeting]

      greeting.toOption shouldEqual Some(Greeting("Hey",Person("Chris"),3))

    }
  }

}
