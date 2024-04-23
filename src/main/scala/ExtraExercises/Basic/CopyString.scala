package ExtraExercises.Basic

object CopyString extends App {
  private val N = 4
  private val LIMIT = 2
  private val word = "hola"

  println(copyString(word))

  private def copyString(word: String): String = {
    if (word.length < 2) word
    else word.substring(0, LIMIT) * N
  }
}
