package ExtraExercises.Control

object SumOfElements extends App {
  println(sumOfElements(Array[Int](2,3,4)))

  private def sumOfElements(array: Array[Int]): Int = {
    var sum: Int = 0

    for (a <- array) {
      sum += a
    }

    sum
  }
}
