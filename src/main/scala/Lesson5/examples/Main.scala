package Lesson5.examples

object Main extends App {
  private val list = List('a', 'b', 'c', 'd')
  println(removeAt(1, list))
  private val list1 = List(1,4,5,8,9)
  private val list2 = List(2,3,6,7,10)
  println(merge(list1, list2))

  println(squareListCase(list1))
  println(squareListMap(list1))

  private def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(_) => List()
    case y :: ys => y +: init(ys)
  }

  private def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
    case Nil => if (n > 0) throw new Error("Not enough elements") else xs
    case x::xs => if (n == 0) removeAt(n - 1, xs) else x +: removeAt(n - 1, xs)
  }

  private def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (Nil, _) => ys
    case (_, Nil) => xs
    case (x::xs1, y::ys1) => if (x < y) x +: merge(xs1, ys) else y +: merge(xs, ys1)
  }

  private def squareListCase(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => (y * y) +: squareListCase(ys)
  }

  private def squareListMap(xs: List[Int]): List[Int] = xs map (x => x * x)

//  private def pack[T](xs: List[T]): List[List[T]] = xs match {
//    case Nil => Nil
//    case x :: xs1 =>
//      val (first, rest) = xs span (y => y == x)
//      first :: pack(rest)
//  }

//  def encode[T](xs: List[T]): List[List[T]] = {
//    pack(xs) map (ys => (ys.head, ys.length))
//  }
}
