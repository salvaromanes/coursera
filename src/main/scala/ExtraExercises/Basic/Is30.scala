package ExtraExercises

object Is30 extends App {
  private val N = 30

  private val x = 15
  private val y = 14
  println(is30(x, y))

  private def is30(x: Int, y: Int): Boolean = {
    x == 30 || y == 30 || (x + y) == N
  }
}
