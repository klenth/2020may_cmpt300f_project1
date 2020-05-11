case class Sequence(val initial: (Int, Int) = (0, 0),
                    val f: (Int, Int) => Int = (a, b) => 0,
                    val done: (Int) => Boolean = (_ => false))
  extends Iterable[Int] {

  override def iterator: Iterator[Int] = new Iter()

  def print(): Unit = foreach(println(_))

  private class Iter extends Iterator[Int]  {

    private var index = 0
    private var last = initial._1
    private var nextLast = initial._2

    override def hasNext: Boolean = !done(calculateNext())

    override def next(): Int = {
      val next = calculateNext()
      index += 1
      this.nextLast = this.last
      this.last = next
      next
    }

    private def calculateNext(): Int = index match {
      case 0 => initial._1
      case 1 => initial._2
      case _ => f(nextLast, last)
    }
  }
}
