package ExtraExercises.Basic

object IfString extends App {
  private val IF = "if"

  private val word = "IfThenElse"
  println(ifString(word))

  private def ifString(word: String): String = {
    if (word.toLowerCase.startsWith(IF)) word
    else IF + word
  }
}
