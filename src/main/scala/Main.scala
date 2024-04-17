import exercisesLesson1.{CountingChange, ParenthesesBalancing}

import scala.collection.immutable.LazyList.cons
import scala.language.postfixOps

object Main extends App {
  private val charListOk = List('(', 'h', 'o', 'l', 'a', ')', '(', ')')
  private val charListNo = List('(', 'h', 'o', 'l', 'a', ')', '(')
  private val charhappy = List(':', '-', ')')

  private val string = "(if (zero? x) max (/ 1 x))"
  private val stringToChar = string.toCharArray

  println(ParenthesesBalancing.balance(charListOk))
  println(ParenthesesBalancing.balance(charListNo))
  println(ParenthesesBalancing.balance(charhappy))
  println(ParenthesesBalancing.balance(stringToChar.toList))

  private val coinsList = List(1, 2)
  private val money = 4

  val list = List(1, 2, 3, 4, 5)
  println(list.mkString(">", ",", "<"))
}
