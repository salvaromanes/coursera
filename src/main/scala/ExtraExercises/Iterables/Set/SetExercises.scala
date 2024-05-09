package ExtraExercises.Iterables.Set

object SetExercises extends App {

  private val s1: Set[Int] = createSet(0, 5)
  private val s2: Set[Int] = createSet(2, 8)
  private val s3: Set[Int] = createSet(12, 21)

  println(s1.union(s2))
  println(s1.intersect(s2))
  println(s1.diff(s2) ++ s2.diff(s1))
  println(s1.subsetOf(s1.union(s2)))
  // Subset
  println(s1.forall(e => s1.union(s2).contains(e)))
  // DisjointSet
  println(s3.forall(e => !s1.union(s2).contains(e)))
  println(s3.sum/s3.size)
  println((s3 - s3.max).max)

  private def createSet(minValue: Int, maxValue: Int): Set[Int] = {
    require(maxValue >= minValue)

    if (minValue == maxValue) Set.empty[Int]
    else Set(minValue) ++ createSet(minValue + 1, maxValue)
  }

}
