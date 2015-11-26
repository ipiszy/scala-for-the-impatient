import java.awt.Color

// 1
object Conversions {
  def inchesToCentimeter(inches: Double) = inches * 2.54
  def gallonsToLiter(gallons: Double) = gallons * 3.78541
  def milesToKilometer(miles: Double) = miles * 1.60934
}

// 2
class UnitConversion(val factor: Double) {
  def convert(num: Double): Double = factor * num
}
object InchesToCentimeter extends UnitConversion(2.54)

// 4
class Point(var x: Int, var y: Int) {}
object Point {
  def apply(x: Int, y: Int) = new Point(x, y)
}

// 6
object CardSuit extends Enumeration {
  val Spade = Value("♠")
  val Heart = Value("♥")
  val Diamond = Value("♦")
  val Club = Value("♣")
}

object Exec6 extends App {
  // 1
  println(Conversions.inchesToCentimeter(10))
  println(Conversions.gallonsToLiter(23))
  println(Conversions.milesToKilometer(3))
  
  // 2
  println(InchesToCentimeter.convert(10))
  
  // 4
  val p = Point(3, 4)
  println(p.x, p.y)
  
  // 5
  println(args.reverse.mkString(" "))
  
  // 6
  val suit = CardSuit.Spade
  println(suit)
  println(CardSuit.withName("♦"))
  println(CardSuit.values)
  
  // 7
  def isCardSuitRed(suit: CardSuit.Value) = 
    (suit == CardSuit.Diamond || suit == CardSuit.Heart)
  println(isCardSuitRed(CardSuit.Club))
  
}