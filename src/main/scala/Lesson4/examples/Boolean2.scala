package Lesson4.examples

abstract class Boolean2 {
  def < (x: Boolean) = {
    ifThenElse (false, x)
  }

  def ifThenElse[T](t: => T, e: => T):T
}
