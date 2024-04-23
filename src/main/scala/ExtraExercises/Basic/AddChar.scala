package ExtraExercises.Basic

object AddChar extends App {
  private val word = "hola"
  println(addChar(word))

  private def addChar(word: String): String = {
    if (word.length < 1) throw new Error("Wrong word")
    else word.charAt(word.length - 1) + word + word.charAt(word.length - 1)
  }
}
