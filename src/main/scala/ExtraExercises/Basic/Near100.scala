package ExtraExercises.Basic

object Near100 extends App {
  println(near100(99, 99))
  println(near100(99, 98))
  println(near100(90, 99))

  private def near100(x: Int, y: Int): Int = {
    if (x == y) 0
    else
      if (Math.abs(x - 100) < Math.abs(y - 100)) x
      else y
  }
}
