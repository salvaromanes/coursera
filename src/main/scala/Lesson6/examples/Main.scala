package Lesson6.examples

import Lesson6.examples.Polynomials.Poly

object Main extends App {
  var xs = Array(1,2,3,44)
  println((xs map (x => x * 2)).mkString("Array(", ", ", ")"))

  var s = "Hello World"
  println(s exists(c => c.isUpper))
  println(s exists(c => c.isLower))
  println(s forall(c => c.isUpper))
  println(s filter (c => c.isUpper))

  private val pairs = List(1,2,3) zip s
  println(pairs.unzip)

  println(s flatMap(c => List('.', c)))

  println(xs.sum)
  println(xs.max)

  println(isPrime(7))
  println(isPrime(85))

  def isPrime(n: Int): Boolean = {
    var i = 2
    var div = true

    while (i <= Math.sqrt(n) && div) {
      if (n % i == 0) div = false
      i = i + 1
    }

    div
  }

  println(NQueens queens(4))
  println(NQueens queens(4) map NQueens.show mkString "\n")

  val p1 = new Poly(Map(1->2.0, 3->4.0, 5->6.2))
  val p2 = new Poly(Map(0->3.0, 3->7.0))
  println(p1)
  println(p2)
  println(p1+p2)
  println(p1.terms(7))
}