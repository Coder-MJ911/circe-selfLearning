package simpleCirce.customCirce

import io.circe.{Decoder, Encoder, HCursor, Json}
import simpleCirce.ancestor.Pet

object PetCirce {

  implicit val encodePet: Encoder[Pet] = (a: Pet) => Json.obj(
    ("id", Json.fromInt(a.id)),
    ("name", Json.fromString(a.name)),
    ("price", Json.fromDoubleOrNull(a.price))
  )

  implicit val decodePet: Decoder[Pet] = (c: HCursor) => for {
    id <- c.downField("id").as[Int]
    name <- c.downField("type").as[String]
    price <- c.downField("price").as[Double]
  } yield {
    Pet(id, name, price)
  }

}
