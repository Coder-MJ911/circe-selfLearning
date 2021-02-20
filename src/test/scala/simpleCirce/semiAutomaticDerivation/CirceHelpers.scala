package simpleCirce.semiAutomaticDerivation

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import simpleCirce.{Foo, User}

trait CirceHelpers {
  implicit val fooDecoder: Decoder[Foo] = deriveDecoder[Foo] //simply: deriveDecoder
  implicit val fooEncoder: Encoder[Foo] = deriveEncoder[Foo]

  implicit val decodeUser: Decoder[User] = Decoder.forProduct3("id", "first_name", "last_name")(User.apply)
  implicit val encodeUser: Encoder[User] = Encoder.forProduct3("id", "first_name", "last_name")(u => (u.id, u.firstName, u.lastName))

}
