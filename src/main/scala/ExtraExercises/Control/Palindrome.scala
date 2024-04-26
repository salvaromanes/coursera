package ExtraExercises.Control

object Palindrome extends App {
  println(palindrome("arroz", "zorra"))

  private def palindrome(s1: String, s2: String): Boolean = {
    s1.reverse == s2
  }
}
