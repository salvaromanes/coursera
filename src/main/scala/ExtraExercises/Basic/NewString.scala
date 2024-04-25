package ExtraExercises.Basic

object NewString extends App {
  println(newString("google"))
  println(newString("git"))
  println(newString("si"))

  private def newString(s: String): String = {
    require(s.length >= 3)
    s.substring(0, 3) + s + s.substring(0, 3)
  }
}
