package Lesson2.examples

import Lesson2.examples.Rationals._

object Main extends App {
  val r1 = new Rationals(1, 3)
  val r2 = new Rationals(5, 7)
  val r3 = new Rationals(3, 2)

  val r12 = addRationals(r1, r2)
  val r13 = addRationals(r1, r3)
  val r23 = addRationals(r2, r3)

  println(r1.toString)
  println(r2.toString)
  println(r3.toString)
  println(r12.toString)
  println(r13.toString)
  println(r23.toString)

  println(r1.neg)
  println(r3.sub(r1))

  println(r1.less(r2))
  println(r1.max(r2))

  println(r1.lessRational(r2))
  println(r1.maxRational(r2))

  //val r0 = new Rationals(1, 0)

  val r4 = new Rationals(5)

  println(r4.toString)
}