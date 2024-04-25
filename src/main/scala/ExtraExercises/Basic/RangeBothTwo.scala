package ExtraExercises.Basic

object RangeBothTwo extends App {
  println(rangeBothTwo(40, 52))
  println(rangeBothTwo(40, 42))
  println(rangeBothTwo(50, 52))
  println(rangeBothTwo(60, 62))

  private def rangeBothTwo(x: Int, y: Int): Boolean = {
    ((40 <= x && x <= 50) && (40 <= y && y <= 50)) || ((50 <= x && x <= 60) && (50 <= y && y <= 60))
  }
}
