import org.junit.jupiter.api.{BeforeEach, Order, Test, TestMethodOrder}
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation

import scala.jdk.CollectionConverters._

@TestMethodOrder(classOf[OrderAnnotation])
class P01_NumbersTest {

  private var student: P01_Numbers = _

  @BeforeEach
  def beforeEach(): Unit = {
    student = new P01_Numbers()
  }

  @Test
  @Order(1)
  def testFibonacci(): Unit = {
    val fib = student.fibonacci()
    assertEquals(Seq(0, 1, 1, 2, 3, 5, 8), fib.slice(0, 7))

    val n = 20
    var x0 = 0
    var x1 = 1
    val iter = fib.iterator

    assertEquals(0, iter.next, "Value wrong at index 0")
    assertEquals(1, iter.next, "Value wrong at index 1")

    for (i <- 2 until n) {
      val x = x0 + x1
      x0 = x1
      x1 = x
      assertTrue(iter.hasNext, "Fibonacci sequence isn't supposed to end")
      assertEquals(x, iter.next, s"Value wrong at index $i")
    }
  }

  @Test
  @Order(2)
  def testAlternate(): Unit = {
    assertEquals(Seq(), student.alternate(0).slice(0, 100), "Wrong result for n=0")
    assertEquals(Seq(1, -1), student.alternate(2).slice(0, 100), "Wrong result for n=2")
    assertEquals(Seq(1, -1, 1, -1, 1, -1, 1), student.alternate(7).slice(0, 100), "Wrong result for n=7")
  }

  @Test
  @Order(3)
  def testComplicated(): Unit = {
    val sub = student.complicated()

    val limit = 500_000
    var x0 = 1
    var x1 = 2
    val iter = sub.iterator

    assertEquals(x0, iter.next, "Value wrong at index 0")
    assertEquals(x1, iter.next, "Value wrong at index 1")

    var i = 2
    var x: Int = 0
    do {
      x = 3 * x0 - 2 * x1 + 1
      x0 = x1
      x1 = x

      if (Math.abs(x) <= limit)
        assertTrue(iter.hasNext, s"Sequence ended too soon: ${String.join(", ", sub.map(_.toString).asJava)}")
      else
        assertTrue(!iter.hasNext, s"Sequence continued too long (${String.join(", ", sub.map(_.toString).slice(0, i + 1).asJava)}, …)")

      assertEquals(x, iter.next, s"Wrong value at index $i")
      i += 1
    } while (Math.abs(x) < limit)
  }
}
