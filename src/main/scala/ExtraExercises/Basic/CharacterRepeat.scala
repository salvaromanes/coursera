package ExtraExercises.Basic

object CharacterRepeat extends App {
  println(characterRepeat("Salvador"))

  private def characterRepeat(word: String): Boolean = {
    var cont = 0

    for (s <- word) {
      if (s == 'a') cont = cont + 1
    }

    (cont >= 2 && 4 >= cont)
  }
}
