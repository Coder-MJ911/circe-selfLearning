package simpleCirce.ancestor

import io.circe.optics.JsonPath.root
import simpleCirce.ancestor.DataPreset.pets

object Main {
  def main(args: Array[String]): Unit = {
    //Todo: cursor （Cats）:
    println("this is using cursor:")
    val contactAddressByCursor: Option[String] = pets.hcursor.downField("contactOwner").get[String]("address").toOption
    val name: Option[String] = pets.hcursor.get[String]("name").toOption
    println("contactAddress = " + contactAddressByCursor)
    println("type = " + name)



    //Todo: optics（Cats + ScalaZ）:
    println("this is using optics:")
    val _contactAddress = root.contactOwner.address.string
    val _name = root.name.string
    val contactAddressByOptics = _contactAddress.getOption(pets)
    val nameByOptics = _name.getOption(pets)
    println("contactAddress = " + contactAddressByOptics)
    println("type = " + nameByOptics)

    //generic：
    println("this is using generic:")

  }
}
