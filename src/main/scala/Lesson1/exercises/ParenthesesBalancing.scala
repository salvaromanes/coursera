package Lesson1.exercises

import scala.annotation.tailrec

/*
I can do it also with tow stacks, one of then to the open parentheses and the
other one to the close parentheses. If the size of each stack are the same,
it works correctly and the parentheses are balanced (return true),
in other case, they are not balanced (return false)
*/

object ParenthesesBalancing {
  def balance(chars: List[Char]): Boolean = lookBalance(chars, 0, 0)

  @tailrec
  private def lookBalance(chars: List[Char], contOpen: Int, contClose: Int): Boolean = chars match {
    case c :: cs => if (c == '(') lookBalance(cs, contOpen + 1, contClose)
      else if(c == ')') lookBalance(cs, contOpen, contClose + 1)
      else lookBalance(cs, contOpen, contClose)
    case Nil => if (contOpen == contClose) true else false
  }

//  @tailrec
//  private def lookBalance(chars: List[Char], contOpen: Int, contClose: Int): Boolean = {
//    if(chars.isEmpty) contOpen == contClose
//    else if (c == '(') lookBalance(chars.tail, (contOpen + 1), contClose)
//      else if (c == ')') lookBalance(chars.tail, contOpen, (contClose + 1))
//      else lookBalance(chars.tail, contOpen, contClose)
//  }
}
