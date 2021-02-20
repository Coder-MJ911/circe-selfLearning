package simpleCirce.semiAutomaticDerivation

import helpers.Specification
import io.circe.syntax.EncoderOps

class SemiAutoSpec extends Specification with CirceHelpers {

  "semi Auto decode & encode" should {
    "first" in {
      val fooJson = Foo(1, "first", c = true).asJson(fooEncoder) // simply: asJson
      val foo = fooJson.as[Foo](fooDecoder) // simply: as[Foo]

      foo.toOption shouldEqual Some(Foo(1,"first",c = true))
    }

    "second" in {
      val userJson = User(1L, "second", "Curry").asJson(encodeUser)
      val user = userJson.as[User](decodeUser)

      user.toOption shouldEqual Some(User(1L, "second", "Curry"))
    }

    "third" in {
      val barFoo = Bar(2, "second").asJson
      val bar = barFoo.as[Bar]
      println("bar = " + bar.toOption)
    }
  }

}
