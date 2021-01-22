package simpleCirce.customCirce

import io.circe.{Decoder, Encoder, HCursor, Json}
import simpleCirce.{ContactOwner, Pet}

object PetCirce {

  implicit val encodePet: Encoder[Pet] = new Encoder[Pet] {
    final def apply(a: Pet) = Json.obj(
      ("id", Json.fromInt(a.id)),
      ("name", Json.fromString(a.name)),
      ("price", Json.fromDoubleOrNull(a.price))
    )
  }

  implicit val decodePet: Decoder[Pet] = new Decoder[Pet] {
    def apply(c: HCursor): Decoder.Result[Pet] =
      for {
        id <- c.downField("id").as[Int]
        name <- c.downField("type").as[String]
        price <- c.downField("price").as[Double]
      } yield {
        new Pet(id, name, price, ContactOwner.apply("street", "123-123-145"))
      }
  }

}
