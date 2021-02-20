package simpleCirce.customDerviation

import helpers.Specification
import io.circe.syntax._
import io.circe.parser.decode
import simpleCirce.SimplePet

class CustomSpec extends Specification with PetCirce{
  "custom decode & encode" should {
    "" in {

      val pet = SimplePet(2, "dog", 2.09)
      val pJson = pet.asJson.noSpaces;
      val p2 = decode[SimplePet](pJson)

      p2 match {
        case Right(p) => p shouldEqual SimplePet(2,"dog",2.09)
        case Left(e) => println(e.fillInStackTrace().getMessage)
      }

    }
  }

}
