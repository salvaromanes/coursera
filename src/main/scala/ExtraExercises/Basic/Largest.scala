package ExtraExercises.Basic

object Largest extends App {
  println(largest(-1, 5, 99))
  println(largest(-1, -2, -3))

  private def largest(x: Int, y: Int, z: Int): Int = {
    List(x,y,z).max
  }
}
