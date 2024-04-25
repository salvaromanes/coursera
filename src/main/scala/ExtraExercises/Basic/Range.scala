package ExtraExercises.Basic

object Range extends App {
  println(range(125, 188))
  println(range(122, 288))

  private def range(n1: Int, n2: Int): Boolean = {
    (100 <= n1 && 200 >= n1) && (100 <= n2 && 200 >= n2)
  }
}
