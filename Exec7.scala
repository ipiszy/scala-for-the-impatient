import collection.JavaConversions
import collection.mutable.{HashMap => ScalaHashMap}
import ipiszy.scala.Random
import java.lang.System
import java.util.{HashMap => JavaHashMap}

object Exec7 extends App {
  // 3
  Random.setSeed((System.currentTimeMillis / 1000).toInt)
  for (i <- 0 to 10) print(Random.nextInt() + ", ")
  println
  for (i <- 0 to 10) print(Random.nextDouble() + ", ")
  println
  
  // 6
  val map = new JavaHashMap[Int, Double]()
  for (i <- 0 until 10) map.put(i, Random.nextDouble())
  val map1 = new ScalaHashMap[Int, Double]()
  JavaConversions.mapAsScalaMap(map).foreach(p => map1.put(p._1, p._2))
  
  // 9
  val name = System.getProperty("user.name")
  Console.out.print("Please enter password for " + name + ": ")
  val pwd = Console.in.readLine().toString()
  if (pwd != "secret") {
    Console.err.println("Password is not correct.")
  } else {
    Console.out.println("Welcome back, " + name + "!")
  }
}