package Lesson2.examples

import scala.annotation.tailrec

object session {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

//  def product(f: Int => Int)(a: Int, b: Int): Int = {
//    if(a > b) 1
//    else f(a) * product(f)(a + 1, b)
//  }

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

  def fact(n: Int) = product(x => x)(1, n)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if(a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }
}
