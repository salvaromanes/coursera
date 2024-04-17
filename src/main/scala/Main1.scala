import example._

object Main1  {
  val list = List(1,3,2)
  val list2 = List(2,4,6)

  println(list + "\n")

  println("sum " + test.sumRec(list))
  println("max " + test.maxRec(list))
  println("Is the list even? " + test.evenList(list))

  println("\n" + list2 + "\n")

  println("sum " + test.sumRec(list2))
  println("max " + test.maxRec(list2))
  println("Is the list even? " + test.evenList(list2) + "\n")

//  val x = 2
//  val y = 3
//
//  println(Lists.func(x)(y))
//  println(Lists.func(y)(y))
//  println(Lists.func(x)(x))
//  println(Lists.func(x))

//  var t:Lists.trip = new trip
//  t.trip()
//  println(t.toString)

  println(test.getMapValue('a'))
  println(test.getMapValue('z') + "\n")

  val s = (1 to 6).toSet
  println(s map (_ + 2))

  val a = "Hello World"
  println(a filter (c => c.isUpper))

  val b: Int = 2
  println(b)
  println(b: Double)

  //Al definir una función dentro de otra es mucho más fácil iterar
  //ya que no es necesario crear variables locales ni globales que vayan
  //variando cada iteración
  def fib(n: Int): Int = {
    def fibIter(i: Int, a: Int, b: Int): Int =
      if (i == n) a else fibIter(i+1, b, a+b)
    fibIter(0, 0, 1)
  }

  val g: String = "Check out the big brains on Brad!"
  println(g indexOf 'o')

  println(test.secondGradeOperations(1, 5, 1))

  val lista = List(1,2,3)
  val lista2 = List(3,2,1)
  val lista3 = List(2,1,1)

  println(test.listTest(lista))
  println(test.listTest(lista2))
  println(test.listTest(lista3))
}
