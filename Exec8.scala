import collection.mutable.ArrayBuffer

// 1
class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class CheckAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double) = {super.deposit(amount - 1)}
  override def withdraw(amount: Double) = {super.withdraw(amount + 1)}
}

// 2
class SavingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private val interestRate = 0.001
  private var transactionCount = 3
  
  def earnMonthlyInterest() {
    super.deposit(super.deposit(0) * interestRate)
    transactionCount = 3
  }
  
  override def deposit(amount: Double) = {
    if (transactionCount > 0) {
      transactionCount -= 1
      super.deposit(amount)
    } else {
      super.deposit(amount - 1)
    }
  }
  
  override def withdraw(amount: Double) = {
    if (transactionCount > 0) {
      transactionCount -= 1
      super.withdraw(amount)
    } else {
      super.withdraw(amount + 1)
    }
  }
}

// 4
abstract class Item {
  def price: Double
  def description: String
}
class SimpleItem(val price: Double, val description: String) extends Item {}
class Bundle extends Item {
  val items: ArrayBuffer[Item] = new ArrayBuffer[Item]
  override def price = items.foldLeft(0.0)((p, item) => p + item.price)
  override def description = {
    val descs = items.foldLeft("")((desc, item) => desc + "\n" + item.description)
    "A bundle which contains " + items.length + " Items. Including:[ \n" + descs + "\n]"
  }
  
  def addItem(item: Item) {items += item}
}

// 5
class Point1(val x: Int, val y: Int) {}
class LabeledPoint(val label: String, x: Int, y: Int) extends Point1(x, y) {}

// 7
class Square(x: Int, y: Int, width: Int)
    extends java.awt.Rectangle(x, y, width, width) {
  def this(width: Int) { this(0, 0, width) }
  def this() { this(0, 0, 0) }
}

object Exec8 extends App {
  val name = new StringBuilder("ipiszy")
  name.synchronized({name ++= " is super!"})
  
  def printAnyRef(ref: AnyRef) {println(ref.eq(Unit))}
  printAnyRef(new String("ipiszy"))

  val bundle = new Bundle()
  bundle.addItem(new SimpleItem(23, "add"))
  bundle.addItem(new SimpleItem(1000, "ipiszy"))
  println(bundle.description)
  val bundle2 = new Bundle()
  bundle2.addItem(bundle)
  bundle2.addItem(new SimpleItem(9999, "hahaha"))
  println(bundle2.description)
  
  val p = new LabeledPoint("Black Friday", 12, -8);
  println(p.x, p.y, p.label)  
}