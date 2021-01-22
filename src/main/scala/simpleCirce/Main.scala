package simpleCirce

import simpleCirce.DataPreset.pets
import io.circe.optics.JsonPath._

object Main {
  def main(args: Array[String]): Unit = {
    //cursor:
    println("this is using cursor:")
    val contactAddressByCursor : Option[String] = pets.hcursor.downField("contactOwner").get[String]("address").toOption
    val name: Option[String] = pets.hcursor.get[String]("name").toOption
    println("contactAddress = " + contactAddressByCursor)
    println("type = " + name)



    //optics:
    println("this is using optics:")
    val _contactAddress = root.contactOwner.address.string
    val _name = root.name.string
    val contactAddressByOptics = _contactAddress.getOption(pets)
    val nameByOptics = _name.getOption(pets)
    println("contactAddress = " + contactAddressByOptics)
    println("type = " + nameByOptics)
  }
}
