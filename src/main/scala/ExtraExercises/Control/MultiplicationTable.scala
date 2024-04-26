package ExtraExercises.Control

object MultiplicationTable extends App {
  println(multiplicationTable(5))

  private def multiplicationTable(n: Int): String = {
    var table: String = ""

    for (i <- 0 to 10) {
      table = table + n + "*" + i + " = " + n*i + "\n"
    }

    table
  }
}
