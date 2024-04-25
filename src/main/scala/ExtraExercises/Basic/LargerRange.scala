package ExtraExercises.Basic

object LargerRange extends App {
  println(largerRange(23, 39))
  println(largerRange(17, 39))
  println(largerRange(23, 29))

  private def largerRange(x: Int, y:Int): Int = {
    val max = List(x, y).max
    if (max > 30 || max < 20) 0
    else max
  }
}
