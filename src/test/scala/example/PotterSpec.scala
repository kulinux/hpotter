package example

import org.scalatest._

class PotterSpec extends FlatSpec with Matchers {
  "One book" should "cost 8" in {
    val potter = new Potter()
    potter.addBook( Book(1) )
    potter.cost() shouldEqual Money(8)
  }

}
