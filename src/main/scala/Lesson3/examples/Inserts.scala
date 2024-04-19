package Lesson3.examples

object Inserts {
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4
  val t3 = new NonEmpty(5, t2, new Empty)
  val t4 = new NonEmpty(1, new Empty, t2)
}

abstract class IntSet {
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  override def toString: String = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  def union(other: IntSet): IntSet = {
    ((left union right) union other) incl elem
  }

  override def toString: String = "{" + left + elem + right + "}"
}