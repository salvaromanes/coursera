package ExtraExercises.FuntionsAndMethods

object Prime extends App {
  println(prime(5))
  println(prime(6))

  private def prime(n: Int): Boolean = {
    var p = true

    for (i <- 2 to Math.sqrt(n).toInt) {
      if (n % i == 0) p = false
    }

    p
  }
}
