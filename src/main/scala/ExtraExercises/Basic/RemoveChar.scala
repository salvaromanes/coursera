package ExtraExercises.Basic

object RemoveChar extends App {
  private val word = "hola"
  private val n = 2

  println(removeChar(n, word))

  private def removeChar(n: Int, word: String): String = {
    word.substring(0, n) + word.substring(n + 1, word.length)
  }
}
