import collection.mutable.ArrayBuffer
import java.util.TimeZone._
import scala.util.Random
import java.util.TimeZone
import java.awt.datatransfer._
import collection.JavaConversions._
import scala.collection.mutable.Buffer

object Exec3 extends App {
  var buffer = ArrayBuffer[Int]()
  buffer += 1
  buffer += (2,3,4)
  
  println(buffer.filter(_ % 2 == 0).map(-_).mkString("~~~<", ":", ">~~~"))
  
  println(for (num <- buffer if (num % 2 == 0)) yield (-num))
  
  def randomGen(n: Int) = {
    val r = Random
    for (i <- 1 to n) yield r.nextInt(n)
  }
  println(randomGen(10), randomGen(-1))
  
  def swapElems(arr: Array[Int]) = {
    for (i <- 1 until (arr.size, 2)) {
      val tmp = arr(i)
      arr(i) = arr(i - 1)
      arr(i - 1) = tmp
    }
    arr
  }
  
  def swapElems2(arr: Array[Int]) = {
    for (i <- 0 until arr.size) yield {
      if (i % 2 == 0) {
        if (i + 1 < arr.size) arr(i + 1)
        else arr(i)
      }
      else arr(i - 1)
    }
  }
  
  println(swapElems(Array[Int](1,2,3,4,5)).mkString(","))
  
  def reorder(arr: Array[Int]) = {
    val t = arr.partition(_ > 0)
    t._1 ++ t._2
  }
  println(reorder(Array[Int](-4, -6, 0, 3, 8, -4, 3, -9)).mkString(","))
  
  def avg(arr: Array[Double]) = {
    if (arr.length == 0) 0
    else arr.sum / arr.length
  }
  println(avg(Array[Double]()))
  
  def reverseSorted(arr: Array[Int]) = {
    arr.sortWith(_ > _)
  }
  println(reverseSorted(Array[Int](-4, -6, 0, 3, 8, -4, 3, -9)).mkString(","))
  
  def reverseSorted(arr: ArrayBuffer[Int]) = {
    arr.sortWith(_ > _)
  }
  println(reverseSorted(ArrayBuffer[Int](-4, -6, 0, 3, 8, -4, 3, -9)).mkString(","))

  def removeDuplicates(arr: Array[Int]) = {
    arr.distinct
  }
  println(removeDuplicates(Array[Int](0,0,0,0)).mkString(","))
  
  def removeAllNegativeExceptForTheFirst(arr: ArrayBuffer[Int]) = {
    var idxes = for (i <- 0 until arr.length if arr(i) < 0) yield i
    idxes = idxes.drop(1).reverse
    for (idx <- idxes) arr.remove(idx)
    arr
  }
  println(removeAllNegativeExceptForTheFirst(ArrayBuffer[Int](2,3,4,-3,-4,5)))
  
  val timezones = TimeZone.getAvailableIDs
  val result = timezones.map(_.stripPrefix("America/")).sortWith(_ < _)
  println(result.mkString(","))
  
  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  val natives: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
  println(natives.mkString(","))
}