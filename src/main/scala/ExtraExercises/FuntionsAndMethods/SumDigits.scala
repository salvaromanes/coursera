package ExtraExercises.FuntionsAndMethods

object SumDigits extends App {
  println(sumDigits(5))
  println(sumDigits(548435))

  private def sumDigits(n: Int): Int = {
    if (n < 10 && n > -10) n
    else (n % 10) + sumDigits(n / 10)
  }
}
