package ExtraExercises

object AbsDifference extends App {
  private val N = 51

  private val n: Int = 52
  println(absDifference(n))

  private def absDifference(n: Int): Int = {
    if (n > N) Math.abs(n - N) * 3
    else Math.abs(n - N)
  }
}
