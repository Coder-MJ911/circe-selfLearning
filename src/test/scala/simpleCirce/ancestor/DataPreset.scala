package simpleCirce.ancestor

import io.circe.Json
import io.circe.parser.parse

trait DataPreset {
  val pets: Json = parse(
    """{
      |      "id": "1",
      |      "name": "cat",
      |      "price": "10.12",
      |      "contactOwner": {
      |        "phone": "1234567890",
      |        "address": "Green Street"
      |      }
      |}""".stripMargin).getOrElse(Json.Null)
}
