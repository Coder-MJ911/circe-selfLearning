package simpleCirce.ancestor

import io.circe.optics.JsonPath.root
import io.circe.syntax.EncoderOps
import io.circe.generic.auto._
//import simpleCirce.ancestor.DataPreset.pets

object Main {
  def main(args: Array[String]): Unit = {

    val pets = Pet(1, "dog", 100.91, ContactOwner("Buddy", "Green Street")).asJson

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


  }
}
