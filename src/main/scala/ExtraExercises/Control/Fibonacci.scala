package ExtraExercises.Control

object Fibonacci extends App {
  println(fibonacci(5))
  println(fibonacci(25))

  private def fibonacci(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci(n - 1) + fibonacci(n - 2)
  }
}
