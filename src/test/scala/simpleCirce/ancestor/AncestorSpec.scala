package simpleCirce.ancestor

import helpers.Specification
import io.circe.optics.JsonPath.root

class AncestorSpec extends Specification with DataPreset {
  "cursor（Cats)" should {

    "" in {
      val contactAddressByCursor: Option[String] = pets.hcursor.downField("contactOwner").get[String]("address").toOption
      val name: Option[String] = pets.hcursor.get[String]("name").toOption

      contactAddressByCursor shouldEqual Some("Green Street")
      name shouldEqual Some("cat")
    }
  }

  "optics (Cats + ScalaZ)" should {

    "" in {
      val contactAddressTemplate = root.contactOwner.address.string
      val nameTemplate = root.name.string
      val contactAddressByOptics = contactAddressTemplate.getOption(pets)
      val nameByOptics = nameTemplate.getOption(pets)

      contactAddressByOptics shouldEqual Some("Green Street")
      nameByOptics shouldEqual Some("cat")
    }
  }
}
