package Lesson3.examples

import Lesson2.examples.Rationals

object Scratch {
  new Rationals(1, 2)
  def error(msg: String): Nothing = throw new Error(msg)
}
