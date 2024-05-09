package ExtraExercises.Iterables.Map

object MapExercises extends App {

  private val m1: Map[Int, Int] = createMap(0, 5)
  private val m2: Map[Int, Int] = createMap(5, 10)

  println(m1)
  println(m2)
  println(m2.get(8))
  println(m2.get(0))

  private def createMap(minValue: Int, maxValue: Int): Map[Int, Int] = {
    require(maxValue >= minValue)

    if (minValue == maxValue) Map.empty[Int, Int]
    else Map(minValue -> minValue) ++ createMap(minValue + 1, maxValue)
  }

}
