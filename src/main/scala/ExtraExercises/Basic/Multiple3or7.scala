package ExtraExercises.Basic

object Multiple3or7 extends App{
  println(multiple3or7(21))
  println(multiple3or7(14))
  println(multiple3or7(9))
  println(multiple3or7(22))

  private def multiple3or7(n: Int): Boolean = {
    require(n >= 0)
    (n % 7) == 0 || (n % 3) == 0
  }
}
