package Lesson1.exercises

import scala.language.postfixOps

object Main extends App {
  private val string1 = "(if (zero? x) max (/ 1 x))"
  private val string2 = "I told him (that it’s not (yet) done). (But he was not listening)"
  private val string3 = ":-)"
  private val string4 = "())("

  println("Parentheses balancing: ")

  println(ParenthesesBalancing.balance(string1.toCharArray.toList))
  println(ParenthesesBalancing.balance(string2.toCharArray.toList))
  println(ParenthesesBalancing.balance(string3.toCharArray.toList))
  println(ParenthesesBalancing.balance(string4.toCharArray.toList))

  println("\nPascal Triangle: ")

  println(PascalTriangle.pascal(0,2))
  println(PascalTriangle.pascal(1,2))
  println(PascalTriangle.pascal(1,3))

  private val coinsList = List(1, 2)
  private val money = 4

  println("\nCounting Change: ")

  println(CountingChange.countChange(money, coinsList))
}
