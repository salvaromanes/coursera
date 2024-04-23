package ExtraExercises.Basic

object Is300 extends App {
  private val MAX = 300
  private val MIN = 100
  private val N = 20

  private val n = 120
  println(is300(n))

  private def is300(n: Int): Boolean = {
    Math.abs(MAX - n) <= 20 || Math.abs(MIN - n) <= 20
  }
}
