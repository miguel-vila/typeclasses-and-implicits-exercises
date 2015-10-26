package typeclasses_and_implicits.exercises._1_typeclasses

import org.scalatest._
import Addable._

class _1_TypeclassesTests extends FlatSpec with Matchers {

  "1. Typeclasses" should "implement an 'addAll' method (exercise 1.1)" in {
    addAll(List(1,2,3)) should equal (6)
    addAll(List.empty[Int]) should equal (0)

    addAll(List("a","b","c")) should equal ("abc")
    addAll(List.empty[String]) should equal ("")
  }

  it should "implement the 'product' method (exercise 1.2)" in {
    val intStringAddable = product[Int,String]
    intStringAddable.zero should equal ((0,""))
    intStringAddable.add((1,"abc"),(2,"def")) should equal ((3,"abcdef"))
  }

  it should "have defined 'product' as an implicit conversion (exercise 1.2)" in {
    """
      |addAll(List((1,"a"), (2,"b"),(3,"c")))
      |addAll(List(("a",1), ("b",2),("c",3)))
    """.stripMargin should compile
  }

}
