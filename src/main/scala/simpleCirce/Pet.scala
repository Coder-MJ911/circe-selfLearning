package simpleCirce

case class Pet(
              id: Int,
              name: String,
              price: Double,
              contactOwner: ContactOwner
              )
case class ContactOwner(
                        address: String,
                        phone: String
                        )