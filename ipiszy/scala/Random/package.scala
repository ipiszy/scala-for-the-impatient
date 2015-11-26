package ipiszy.scala

package object Random {
  private var prev: Double = 0
  private val a = 1664525
  private val b = 1013904223
  private val n = 32
  
  private def next() = {prev = prev * a + b % (math.pow(2, n))}
  def nextInt() = {next(); prev.toInt}
  def nextDouble() = {next(); prev.toDouble}
  def setSeed(seed: Int) {prev = seed}
}