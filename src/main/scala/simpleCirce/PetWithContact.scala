package simpleCirce

case class PetWithContact(
                id: Int,
                name: String,
                price: Double,
                contactOwner: ContactOwner
              )

case class ContactOwner(
                       name: String,
                       address: String
                       )
