import org.junit.jupiter.api.{BeforeEach, Order, Test, TestMethodOrder}
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation

import scala.jdk.CollectionConverters._

@TestMethodOrder(classOf[OrderAnnotation])
class P02_StudentsTest {

  private var student: P02_Students = _
  private val john = new Student("3207771", "John", "Sheridan", "jsheridan@earthforce.earth.gov")
  private val susan = new Student("3113593", "Susan", "Ivanova", "sivanova@earthforce.earth.gov")
  private val marcus = new Student("5538515", "Marcus", "Cole", "cole@arisia.link.earth.org")
  private val kosh = new Student("0000000", "Kosh", "Naranek", null)
  private val lyta = new Student("4502882", "Lyta", "Alexander", "a_lyta@psi.earth.mil")
  private val londo = new Student("6286189", "Londo", "Mollari", "wine_women_song@centauri.gov")

  @BeforeEach
  def beforeEach(): Unit = {
    student = new P02_Students()
  }

  @Test
  @Order(1)
  def testStudentEmail(): Unit = {
    val f = student.studentEmail()
    assertEquals(john.email, f(john))
    assertEquals(susan.email, f(susan))
    assertEquals(marcus.email, f(marcus))
  }

  @Test
  @Order(2)
  def testStudentFullName(): Unit = {
    val f = student.studentFullName()
    assertEquals("Sheridan, John", f(john))
    assertEquals("Naranek, Kosh", f(kosh))
    assertEquals("Alexander, Lyta", f(lyta))
  }

  @Test
  @Order(3)
  def testAnd(): Unit = {
    assertEquals(true, student.and(_ => true, _ => true)(londo))
    assertEquals(false, student.and(_ => true, _ => false)(londo))
    assertEquals(false, student.and(_ => false, _ => true)(londo))
    assertEquals(false, student.and(_ => false, _ => false)(londo))
  }
}
