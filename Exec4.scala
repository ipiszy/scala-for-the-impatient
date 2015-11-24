import java.io.File
import collection.JavaConversions.propertiesAsScalaMap

object Exec4 extends App{
  val ipiszyMap = Map("ipiszy"->1, "ADD"->2)
  var num: Int = 3
  num.+=(1)
  num.+(3)
  num+3
  println(num)
  
  val arr = Array[Int](1,4,6,-1)
  arr(0) = 2
  println(arr.mkString(","))
  
  var map = collection.mutable.Map("ipiszy"->1)
  println(map.getClass, map.mkString)
  var map1 = collection.mutable.Map()
  println(map1.getClass)
  println(map1.mkString)
  var map2 = collection.mutable.Map[Int, Int]()
  println(map2.getClass)
  map2.+=(2->3, 1->2, 3->4)
  println(map2.mkString(", "))
  
  val var1 = map2.get(4)
  println(var1, var1.getOrElse(-1))
  val var2 = map2.get(1)
  println(var2, var2.getOrElse(-1))
  
  val map3 = collection.mutable.LinkedHashMap("ipiszy"->4)
  
  
  // 1
  val gizmosMap = Map("ipiszy"->100, "add"->0, "sbb"->5)
  val gizmosDiscountMap = {for ((k, v) <- gizmosMap) yield (k, v * 0.1)}
  println(gizmosDiscountMap.mkString(", "))
  
  // 2
  val in = new java.util.Scanner(new java.io.File("/Users/carolzhang/ipiszy"))
  val wordCount = new collection.mutable.HashMap[String, Int]()
  while (in.hasNext()) {
    val word = in.next()
    wordCount.update(word, wordCount.getOrElse(word, 0) + 1)
  }
  println(wordCount.mkString(", "))
  
  // 3
  val in2 = new java.util.Scanner(new java.io.File("/Users/carolzhang/ipiszy"))
  var wordCount2 = new collection.immutable.HashMap[String, Int]()
  while (in2.hasNext()) {
    val word = in2.next()
    wordCount2 = wordCount2 + (word -> (wordCount2.getOrElse(word, 0) + 1))
  }
  println(wordCount2.mkString(", "))
  
  // 4
  val in3 = new java.util.Scanner(new java.io.File("/Users/carolzhang/ipiszy"))
  var wordCount3 = new collection.immutable.TreeMap[String, Int]()
  while (in3.hasNext()) {
    val word = in3.next()
    wordCount3 = wordCount3 + (word -> (wordCount3.getOrElse(word, 0) + 1))
  }
  println(wordCount3.mkString(", "))
  
  // 5
  val in4 = new java.util.Scanner(new java.io.File("/Users/carolzhang/ipiszy"))
  val wordCount4 = new java.util.TreeMap[String, Int]()
  while (in4.hasNext()) {
    val word = in4.next()
    wordCount4.put(word, wordCount4.getOrDefault(word, 0) + 1)
  }
  println(wordCount4)
  
  // 6
  val days = new collection.mutable.LinkedHashMap[String, Int]()
  days.+=("Monday"->java.util.Calendar.MONDAY)
  days.+=("Tuesday"->java.util.Calendar.TUESDAY)
  days.+=("Wednesday"->java.util.Calendar.WEDNESDAY)
  days.+=("Thursday"->java.util.Calendar.THURSDAY)
  days.+=("Friday"->java.util.Calendar.FRIDAY)
  days.foreach(p => println(p._1, p._2))
  
  // 7
  val properties = System.getProperties()
  var maxLen = 0
  for ((k, v) <- properties) maxLen = maxLen.max(k.length())
  for ((k, v) <- properties) {
    print(k)
    for (i <- 0 to maxLen - k.length()) print(" ")
    println(v)
  }
  
  // 8
  def minMax(values: Array[Int]) = {
    if (values.length > 0) {
      var min, max = values(0)
      values.foreach(value => {min = min.min(value); max = max.max(value)})
      (min, max)
    }
  }
  println(minMax(Array(3,6,1,9)))
  println(minMax(new Array[Int](0)))
  
  // 9
  def lteqgt(values: Array[Int], v: Int) = {
    var lt, eq, gt = 0
    for (value <- values) {
      if (value < v) lt += 1
      else if (value > v) gt += 1
      else eq += 1
    }
    (lt, eq, gt)
  }
  println(lteqgt(Array(3,6,1,-5,-4), 0))
  
  // 10
  println("Hellp".zip("World"))
  
}