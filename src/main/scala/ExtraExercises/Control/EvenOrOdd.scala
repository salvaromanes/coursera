package ExtraExercises.Control

object EvenOrOdd extends App {
  println(evenOrOdd(1))
  println(evenOrOdd(2))

  private def evenOrOdd(n: Int): String = {
    if (n % 2 == 0) "even"
    else "odd"
  }
}
