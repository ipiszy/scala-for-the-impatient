
object Exec2 extends App {
  val ipiszy = if (true) "super" else "sbb"
  println(ipiszy)
  val sbb = if (false) "super"
  println(sbb.getClass)
  println(sbb.isInstanceOf[Unit])
  val void = Unit
  println(void.getClass)
  val num = if (false) 34
  println(num.getClass)
  var x = args(0).toInt
  val mix = if (x > 0) 21 else "ipiszy"
  println(mix.isInstanceOf[Int])
  println(mix.isInstanceOf[String])
  val javaInt = new Integer(0)
  val none = {}
  println(none.getClass, none, none.isInstanceOf[Unit])
  def signum(num: Int) = if (num > 0) 1 else 0
  println(signum(34))
  var y = 2
  val z = y = 1
  println(z)
  
  for (i <- 10.to(0, -1)) println(i)
  val test1 = 10 to 0 -1
  val test2 = 10.to(0, -1)
  println(test1)
  println(test2)
  
  def countDown(n: Int) {
    for (i <- n.to(0, -1)) println(i)
  }
  
  countDown(5)
  
  def productOfUnicodes(s: String) = {
    println("product of unicodes")
    var product:BigInt = BigInt(1)
    for (c <- s) {
      println(c, c.toInt)
      product *= c.toInt
    }
    product
  }
  
  println(productOfUnicodes("ipiszy is a super girl."))
  
  var product: BigInt = 1
  "add is sbb".foreach { product *= _.toInt }
  println(product)
  
  def productR(s: String): BigInt = {
    if (s.isEmpty) 1
    else s.head.toInt * productR(s.tail)
  }
  
  println(productR("Add loves ipiszy."))
  
  def powerN(x: Double, n: Int): Double = {
    if (n == 0) 1
    else if (n < 0) 1 / powerN(x, -n)
    else if (n % 2 == 0) { val y = powerN(x, n / 2); y * y}
    else powerN(x, n - 1) * x
  }
  println(powerN(-2, -4))
}