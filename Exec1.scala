import math.BigInt._
import math._
import util.Random
import collection.immutable._

object Exec1 extends App {  
    println(math.sqrt(3))
    println(math.pow(math.sqrt(3), 2))
    println("crazy" * 3)
    println(math.pow(2, 1024))
    println(BigInt(2).pow(1024))
    println(probablePrime(3, Random))
    println(BigInt(50, Random).toString(36))
    println("ipiszy is super"(0))
    println("add is sbb".last)
    val ipiszy = "ipiszy is super"
    ipiszy.take(3).dropRight(2)    
}