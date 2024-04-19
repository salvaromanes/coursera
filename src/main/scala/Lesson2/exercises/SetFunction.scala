package Lesson2.exercises

import scala.annotation.tailrec

object SetFunction {
  private type FunSet = Int => Boolean

  //Exercise 1
  def contains(s: FunSet, elem: Int): Boolean = s(elem)

  //Exercise 2.1.1
  def singletonSet(elem: Int): FunSet = (x: Int) => x == elem

  def addElemSet(s: FunSet, elem: Int): FunSet = {
    (e: Int) => contains(s, elem) || e == elem
  }

  //Exercise 2.1.2
  def union(s: FunSet, t: FunSet):FunSet = {
    (x: Int) => contains(t, x) || contains(s, x)
  }

  def intersect(s: FunSet, t: FunSet): FunSet = {
    (x: Int) => contains(t, x) && contains(s, x)
  }

  def diff(s: FunSet, t: FunSet): FunSet = {
    (x: Int) => contains(t, x) && !contains(s, x) || !contains(t, x) && contains(s, x)
  }

  //Exercise 2.1.3
  def filter(s: FunSet, p: Int => Boolean): FunSet = {
    (x: Int) => p(x) && contains(s, x)
  }

  //Exercise 2.2.1
  private def forall(s: FunSet, p: Int => Boolean): Boolean = {
    //Iterator move between -1000 to 1000
    @tailrec
    def iter(a: Int): Boolean = {
      if (a > 1000) true                      //Iterator ends and all elements of FunSet pass the predicate p -> return true
      else if (contains(s, a) && !p(a)) false //First element that doesn't pass the predicate p makes iterator ends -> return false
      else iter(a + 1)                        //Continue searching elements
    }
    iter(-1000)
  }

  //Exercise 2.2.2
  def exists(s: FunSet, p: Int => Boolean): Boolean = {
    //If an element (example 2) doesn't pass the no predicate (example not even) forall will return false
    //it means that exist an element (2) that pass the predicate (even)
    !forall(s, x => !p(x))
  }

  //Exercise 2.2.3
  def map(s: FunSet, f: Int => Int): FunSet = {
    //If an element (example 2) pass a function (example / 2) exist will return true and map will add it
    //on the FunSet (SingletonSet(1) in this example) that will return
    def applyFuncToSet: FunSet = {
      (x: Int) => exists(s, y => f(y) == x)
    }
    applyFuncToSet
  }

}
