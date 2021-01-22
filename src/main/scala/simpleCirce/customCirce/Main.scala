package simpleCirce.customCirce

import io.circe
import simpleCirce.{ContactOwner, Pet}
import io.circe.parser.decode
import io.circe.syntax._
import simpleCirce.DataPreset.pets

object Main {
  def main(args: Array[String]): Unit = {
    //custom codes:
    println("custom codes:")
    import PetCirce._
    val pet = Pet(2, "cat", 2.09, ContactOwner("street", "123-456-789"))
    val pJson = pet.asJson.noSpaces;
    val p2: Either[circe.Error, Pet] = decode[Pet](pJson)

    println(p2)
  }
}
