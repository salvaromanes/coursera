package Lesson6.examples

object Pairs extends App {
  val n = 7

  println((1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (pair => Main.isPrime(pair._1 + pair._2)))
  println(scalarProduct(List(2,3,4), List(1,4,5)))

  def scalarProduct(xs: List[Double], ys: List[Double]): Double = (for ((x,y) <- xs zip ys) yield x*y).sum
}
