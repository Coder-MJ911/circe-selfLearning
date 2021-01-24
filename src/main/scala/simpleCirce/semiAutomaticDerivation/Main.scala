package simpleCirce.semiAutomaticDerivation

import io.circe._
import io.circe.generic.semiauto._
import io.circe.syntax.EncoderOps
object Main {

  implicit val fooDecoder: Decoder[Foo] = deriveDecoder[Foo] //simply: deriveDecoder
  implicit val fooEncoder: Encoder[Foo] = deriveEncoder[Foo]

  implicit val decodeUser: Decoder[User] = Decoder.forProduct3("id", "first_name", "last_name")(User.apply)
  implicit val encodeUser: Encoder[User] = Encoder.forProduct3("id", "first_name", "last_name")(u => (u.id, u.firstName, u.lastName))

  def main(args: Array[String]): Unit = {
    // Todo: first
    val fooJson = Foo(1, "first", c = true).asJson(fooEncoder) // simply: asJson
    val foo = fooJson.as[Foo](fooDecoder) // simply: as[Foo]
    println("foo = " + foo.toOption)

    // Todo: second
//    val barFoo = Bar(2, "second").asJson
//    val bar = barFoo.as[Bar]
//    println("bar = " + bar.toOption)

    // Todo: third
    val userJson = User(1L, "third", "Curry").asJson(encodeUser)
    val user = userJson.as[User](decodeUser)
    println("user = " + user.toOption)
  }
}

case class Foo(a: Int, b: String, c: Boolean)



