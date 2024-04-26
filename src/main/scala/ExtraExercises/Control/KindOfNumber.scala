package ExtraExercises.Control

object KindOfNumber extends App {
  println(kindOfNumber(-1))
  println(kindOfNumber(0))
  println(kindOfNumber(1))

  private def kindOfNumber(n: Int): String = {
    if (n == 0) "zero"
    else if (n > 0) "positive"
    else "negative"
  }
}
