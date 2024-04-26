package ExtraExercises.Control

object Maximum extends App {
  println(maximum(5, 8))
  println(maximum(8, 5))

  private def maximum(x: Int, y: Int): Int = {
    if (x > y) x
    else y
  }
}
