package Lesson2.examples

import scala.annotation.tailrec

object Rationals {
  def addRationals(r1: Rationals, r2: Rationals): Rationals = {
    r1.add(r2)
  }

  def toString(r: Rationals): Unit = {
    println(r.toString)
  }
}

class Rationals(x: Int, y:Int) {
  require(y != 0, "Denominator must be nonzero")

  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def this(x: Int) = this(x, 1)

  private def numer: Int = x
  private def denom: Int = y

  def less(that: Rationals): Boolean =
    numer * that.denom < that.numer * denom

  def lessRational(that: Rationals): Rationals =
    if (this.less(that)) this else that

  def maxRational(that: Rationals): Rationals =
    if (this.less(that)) that else this

  def max(that: Rationals) =
    numer * that.denom > that.numer * denom

  def add(that: Rationals) =
    new Rationals(
      numer * that.denom + that.numer * denom, denom * that.denom
    )

  def neg: Rationals = {
    new Rationals(-numer, denom)
  }

  def sub(that: Rationals): Rationals = {
    add(that.neg)
  }

  override def toString: String = {
    val g = gcd(x, y)
    (numer / g) + " / " + (denom / g)
  }
}