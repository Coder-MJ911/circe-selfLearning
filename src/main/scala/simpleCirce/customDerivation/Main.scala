package simpleCirce.customDerivation

import io.circe.parser.decode
import io.circe.syntax._
import simpleCirce.ancestor.Pet

object Main {
  def main(args: Array[String]): Unit = {
    //custom codes:
    println("custom codes:")
    import PetCirce._
    val pet = Pet(2, "cat", 2.09)
    val pJson = pet.asJson.noSpaces;
    val p2 = decode[Pet](pJson)

    p2 match {
      case Right(p) => println(p)
      case Left(e) => println(e.fillInStackTrace().getMessage)
    }
  }
}
