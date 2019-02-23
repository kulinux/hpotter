package example


case class Money(money: Int)

case class Book(book: Int)

class Potter {

  def cost(): Money = Money(8)

  def addBook(book: Book) = {}

}
