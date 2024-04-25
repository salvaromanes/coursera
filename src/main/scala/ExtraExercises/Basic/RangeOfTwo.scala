package ExtraExercises.Basic

object RangeOfTwo extends App {
  println(rangeOfThree(25, 55))
  println(rangeOfThree(15, 75))

  private def rangeOfThree(n1: Int, n2: Int): Boolean = {
    (n1 <= 20 || n2 >= 50) || (n2 <= 20 || n1 >= 50)
  }
}