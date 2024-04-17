package exercisesLesson1

import scala.annotation.tailrec

object ParenthesesBalancing {
  def balance(chars: List[Char]): Boolean = lookBalance(chars, 0, 0)

  @tailrec
  private def lookBalance(chars: List[Char], contOpen: Int, contClose: Int): Boolean = chars match {
    case c :: cs => if (c == '(') lookBalance(cs, (contOpen + 1), contClose)
      else if(c == ')') lookBalance(cs, contOpen, (contClose + 1))
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
