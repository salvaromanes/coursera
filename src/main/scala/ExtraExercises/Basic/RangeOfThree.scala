package ExtraExercises.Basic

object RangeOfThree extends App {
  println(rangeOfThree(25, 55, 101))
  println(rangeOfThree(15, 55, 101))

  private def rangeOfThree(n1: Int, n2: Int, n3: Int): Boolean = {
    (20 <= n1 && n1 <= 50) || (20 <= n2 && n2 <= 50) || (20 <= n3 && n3 <= 50)
  }
}
