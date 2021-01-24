package simpleCirce.semiAutomaticDerivation

import io.circe._
import io.circe.generic.semiauto._
import io.circe.syntax.EncoderOps
object SemiAuto {

  implicit val fooDecoder: Decoder[Foo] = deriveDecoder[Foo] //simply: deriveDecoder
  implicit val fooEncoder: Encoder[Foo] = deriveEncoder[Foo]

  def main(args: Array[String]): Unit = {
    // Todo: have an Encoder or Decoder defined in code and semi-automatic derivation can help:
    val fooJson = Foo(1, "first", c = true).asJson(fooEncoder) // simply: asJson
    val foo = fooJson.as[Foo](fooDecoder) // simply: as[Foo]
    println("foo = " + foo.toOption)

    // Todo: circe-generic has a @JsonCodec annotation that simplifies the use of semi-automatic generic derivation:
//    val barFoo = Bar(2, "second").asJson
//    val bar = barFoo.as[Bar]
//    println("bar = " + bar)
  }
}

case class Foo(a: Int, b: String, c: Boolean)



