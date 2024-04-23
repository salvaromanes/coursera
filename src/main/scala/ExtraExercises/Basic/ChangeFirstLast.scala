package ExtraExercises.Basic

object ChangeFirstLast extends App {
  private val word = "scala"
  println(changeFirstLast(word))

  private def changeFirstLast(word: String): String = {
    if (word.length >= 2) word.charAt(word.length - 1) + word.substring(1, word.length - 1) + word.charAt(0)
    else word
  }
}
