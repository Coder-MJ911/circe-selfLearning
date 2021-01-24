package simpleCirce

import simpleCirce.DataPreset.pets
import io.circe.optics.JsonPath._

object Main {
  def main(args: Array[String]): Unit = {
    //cursor:
    println("this is using cursor:")
    val name: Option[String] = pets.hcursor.get[String]("name").toOption
    println("type = " + name)



    //optics:
    println("this is using optics:")
    val _name = root.name.string
    val nameByOptics = _name.getOption(pets)
    println("type = " + nameByOptics)

    //generic：
    println("this is using generic:")

  }
}
