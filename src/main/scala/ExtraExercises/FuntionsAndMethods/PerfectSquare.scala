package ExtraExercises.FuntionsAndMethods

object PerfectSquare extends App {
  println(perfectSquare(25))
  println(perfectSquare(2552))

  private def perfectSquare(n: Int): Boolean = {
    val square = Math.sqrt(n).toInt
    n == square * square
  }
}
