package Lesson3.examples

import Inserts._
import Nth._

object Main extends App {
  println(t2.toString)
  println(t3.union(t4))

  //println(error("Error in Main"))

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

  println(nth(0, list))
  println(nth(2, list))
  //println(nth(5, list))
}
