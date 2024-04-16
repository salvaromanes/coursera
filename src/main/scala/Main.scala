import example.Lists

object Main extends App {
  val list = List(1,3,2)
  val list2 = List(2,4,6)

  println(list + "\n")

  println("sum " + Lists.sumRec(list))
  println("max " + Lists.maxRec(list))
  println("Is the list even? " + Lists.evenList(list))

  println("\n" + list2 + "\n")

  println("sum " + Lists.sumRec(list2))
  println("max " + Lists.maxRec(list2))
  println("Is the list even? " + Lists.evenList(list2) + "\n")

//  val x = 2
//  val y = 3
//
//  println(Lists.func(x)(y))
//  println(Lists.func(y)(y))
//  println(Lists.func(x)(x))
//  println(Lists.func(x))


}
