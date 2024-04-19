package Lesson3.examples

import Lesson3.examples._

import scala.annotation.tailrec

object Nth {
  @tailrec
  def nth[T](n: Int, list: List[T]): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException("Wrong value")
    else if (n == 0) list.head
    else nth(n - 1, list.tail)
  }
}
