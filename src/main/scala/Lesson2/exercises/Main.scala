package Lesson2.exercises

object Main extends App {
  private val set1 = SetFunction.singletonSet(1)
  private val set2 = SetFunction.singletonSet(2)
  private val set3 = SetFunction.singletonSet(3)

  println(SetFunction.contains(set1, 1)) //True
  println(SetFunction.contains(set2, 1)) //False
  println(SetFunction.contains(set3, 3) + "\n") //True

  private val elem = 8
  private val singletonSet = SetFunction.singletonSet(elem)
  private val newSet = SetFunction.addElemSet(set1, elem)

  println(SetFunction.contains(newSet, elem) + "\n") //True

  private val unionSigle = SetFunction.union(set1, singletonSet)

  println(SetFunction.contains(unionSigle, elem) + "\n") //True

  private val unionSet = SetFunction.union(set1, newSet)
  private val intersectSet = SetFunction.intersect(set1, newSet)
  private val diffSet = SetFunction.diff(set1, newSet)

  println(SetFunction.contains(unionSet, elem)) //True
  println(SetFunction.contains(intersectSet, elem)) //False
  println(SetFunction.contains(diffSet, elem) + "\n") //True

  private def even(n: Int): Boolean = n % 2 == 0
  private val evenSet = SetFunction.singletonSet(2)

  println(SetFunction.contains(SetFunction.filter(evenSet, even), 2)) //True
  println(SetFunction.contains(SetFunction.filter(evenSet, even), 5) + "\n") //False

  println(SetFunction.exists(evenSet, even)) //True
  println(SetFunction.exists(set1, even) + "\n") //False

  private def divide2(n: Int): Int = n / 2

  println(SetFunction.contains(SetFunction.map(evenSet, divide2), 1)) //True
}
