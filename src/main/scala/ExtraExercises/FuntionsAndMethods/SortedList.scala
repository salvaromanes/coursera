package ExtraExercises.FuntionsAndMethods

object SortedList extends App {
  println(sortedList(List(1,2,3,4)))
  println(sortedList(List(4,1,2,3,4)))

  private def sortedList(list: List[Int]): Boolean = list match {
    case l::Nil => true
    case x::y::ls => if (x < y) sortedList(y::ls) else false
  }
}
