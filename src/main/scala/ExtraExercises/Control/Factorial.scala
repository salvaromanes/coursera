package ExtraExercises.Control

object Factorial extends App {
  println(factorial(3))
  println(factorial(5))

  private def factorial(n: Int): Int = n match {
    case 0 => 1
    case _ => n * factorial(n - 1)
  }
}
