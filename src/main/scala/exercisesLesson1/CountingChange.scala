package exercisesLesson1

object CountingChange {
  def countChange(money: Int, coins: List[Int]): Int = {
    count(money, coins)
  }

  private def count(m: Int, c: List[Int]): Int = {
    if (m == 0) 1
    else if (m < 0 || c.isEmpty) 0
    else count(m - c.head, c) + count(m, c.tail)
  }
}
