package ExtraExercises.Basic

object YtString extends App {
  println(ytString("ytIllojuan"))
  println(ytString("Illojuan"))

  private def ytString(s: String): String = {
    if (s.substring(0, 2) == "yt") s.substring(2)
    else s
  }
}
