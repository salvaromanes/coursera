package ExtraExercises

object SumValues extends App {
  private val x:Int = 3
  private val y:Int = 3
  println(sumValues(x, y))

  private def sumValues(x: Int, y:Int): Int = {
    if (x == y) (x + y) * 3
    else x + y
  }
}
