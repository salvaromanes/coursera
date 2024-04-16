package example

object test {
  def sumRec(xs: List[Int]): Int = xs match {
    case head :: tail => sumRec(tail) + head
    case Nil => 0
  }

  /*
    Importante -> Los casos se tienen que ordenar del más pequeño al más genérico para
    que no falle la ejecución
  */
  def maxRec(xs: List[Int]): Int = xs match {
    case Nil => throw new NoSuchElementException("Empty list")
    case head :: Nil => head
    case head :: tail =>
      if (head > maxRec(tail)) head
      else maxRec(tail)
  }

  def evenList(xs: List[Int]): Boolean = xs match {
    case Nil => throw new NoSuchElementException("Empty list")
    case head :: Nil => auxEven(head)
    case head :: tail =>
      if (auxEven(head)) evenList(tail)
      else false
  }

  private def auxEven(x: Int): Boolean =
    if (x % 2 == 0) true
    else false

  //Funciones que devuelven una función que devuelve un tipo de dato concreto
  def func(x: Int): Function[Int, Int] = {
    new Function[Int, Int]() {
      //Cuando tienes una funcion dentro de otra necesitas obligatoriamente el
      //método apply
      def apply(y: Int): Int = x + y
    }
  }

  val map = Map('a' -> 2, 'b' -> 3, 'd' -> 8)

  def getMapValue(s: Char): String = {
    map get s match {
      case Some(v) => "Value " + v
      case None => "Value not found"
    }
  }

  //  class car(people: Int, capacity: Int){
//    require(capacity >= people, "Car is full")
//
//    var c: Int = capacity
//    var p: Int = people
//
//    def getCapacity: Int = {
//      c
//    }
//
//    def getPeople: Int = {
//      p
//    }
//
//    override def toString: String = "Capacity = " + c + " and people = " + p
//  }
//
//  class trip(){
//    var count: Int = 0
//    var c:car = new car(1, 5)
//
//    def trip() = {
//      count += 1
//    }
//
//    override def toString: String = "There are " + count + " cars in the trip\n"+ c.toString
//  }


}

