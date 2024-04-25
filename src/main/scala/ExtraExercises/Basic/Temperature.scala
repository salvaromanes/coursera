package ExtraExercises.Basic

object Temperature extends App {
  println(temperature(-5, 105))
  println(temperature(105, -5))
  println(temperature(15, 250))

  private def temperature(t1: Int, t2: Int) = {
    (t1 < 0 && t2 > 100) || (t2 < 0 && t1 > 100)
  }
}
