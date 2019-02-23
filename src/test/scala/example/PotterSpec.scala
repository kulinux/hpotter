package example

import org.scalatest._

class PotterSpec extends FlatSpec with Matchers {
  "One book" should "cost 8" in {
    val potter = new Potter()
    potter.addBook( Book(1) )
    potter.cost() shouldEqual Money(8)
  }

  "Two different books" should "cost 16 - 5%" in {
    val potter = new Potter()
    potter.addBook( Book(1) )
    potter.addBook( Book(2) )
    potter.cost() shouldEqual Money((8*2*95.0)/100)
  }

  "Two equals books" should "have no discount" in {
    val potter = new Potter()
    potter.addBook( Book(1) )
    potter.addBook( Book(1) )
    potter.cost() shouldEqual Money(8*2)
  }

  "Two equals + Other book" should "have one discount" in {
    val potter = new Potter()
    potter.addBook( Book(1) )
    potter.addBook( Book(1) )
    potter.addBook( Book(2) )
    potter.cost() shouldEqual Money( 8 + (8*2*95.0)/100 )
  }


  "Three different books" should "cost 24 - 10%" in {
    val potter = new Potter()
    potter.addBook( Book(1) )
    potter.addBook( Book(2) )
    potter.addBook( Book(3) )
    potter.cost() shouldEqual Money((8*3*90.0)/100)
  }
}
