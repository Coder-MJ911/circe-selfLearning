package simpleCirce.customDerviation

import helpers.Specification
import simpleCirce.customDerivation.Pet
import io.circe.syntax._
import io.circe.parser.decode

class CustomSpec extends Specification with PetCirce{
  "custom decode & encode" should {
    "" in {

      val pet = Pet(2, "dog", 2.09)
      val pJson = pet.asJson.noSpaces;
      val p2 = decode[Pet](pJson)

      p2 match {
        case Right(p) => p shouldEqual Pet(2,"dog",2.09)
        case Left(e) => println(e.fillInStackTrace().getMessage)
      }

    }
  }

}
