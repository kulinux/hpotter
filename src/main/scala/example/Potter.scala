package example

import example.Potter.discount

import scala.collection.mutable.ArrayBuffer


case class Money(money: Double)

case class Book(book: Int)

case class ShoppingCart() {

  var books = new ArrayBuffer[Book]()

  def size() = books.size

  def append(book: Book) = books.append(book)

  def haveSameBook(booksArgs: ArrayBuffer[Book]) = booksArgs.distinct.size != booksArgs.size

  def costDifferent(booksArgs: ArrayBuffer[Book]): Money = {
    assert(haveSameBook(booksArgs) == false)

    var percent = 0

    if(booksArgs.size == 1) percent = 0
    if(booksArgs.size == 2) percent = 5
    if(booksArgs.size == 3) percent = 10
    if(booksArgs.size == 4) percent = 20
    if(booksArgs.size == 5) percent = 25


    Money(discount(8* booksArgs.size, percent ))
  }


}

class Potter {


  val books = ShoppingCart()

  def cost(): Money = {
    val groupBy = books.books.map(b =>
      (books.books.count(b.equals(_)), b)
    ).distinct

    val conDosElem = groupBy.filter(_._1 == 2)
    val conUnElem = groupBy.filter(_._1 >= 1)


    Money( books.costDifferent(conDosElem.map(_._2)).money +
      books.costDifferent(conUnElem.map(_._2)).money )

  }


  def addBook(book: Book) = {
    books.append(book)
  }

}


object Potter {
  def discount(
         number: Double,
         percent: Double) = number * ( (100 - percent) / 100 )
}
