package ExtraExercises.Basic

object ScString extends App {
  private val SC = "Sc"

  println(scString("Scala"))
  println(scString("escorpion"))

  private def scString(s: String): Boolean = {
    s.substring(0, 2) == SC
  }
}
