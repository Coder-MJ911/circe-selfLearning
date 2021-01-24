package simpleCirce.ancestor

case class Pet(
                id: Int,
                name: String,
                price: Double,
                contactOwner: ContactOwner
              )

case class ContactOwner(
                       name: String,
                       address: String
                       )
