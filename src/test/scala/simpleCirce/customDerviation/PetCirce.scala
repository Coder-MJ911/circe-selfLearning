package simpleCirce.customDerviation

import io.circe.{Decoder, Encoder, HCursor, Json}
import simpleCirce.SimplePet

trait PetCirce {

  implicit val encodePet: Encoder[SimplePet] = (a: SimplePet) => Json.obj(
    ("id", Json.fromInt(a.id)),
    ("name", Json.fromString(a.name)),
    ("price", Json.fromDoubleOrNull(a.price))
  )

  implicit val decodePet: Decoder[SimplePet] = (c: HCursor) => for {
    id <- c.downField("id").as[Int]
    name <- c.downField("name").as[String]
    price <- c.downField("price").as[Double]
  } yield {
    SimplePet(id, name, price)
  }

}
