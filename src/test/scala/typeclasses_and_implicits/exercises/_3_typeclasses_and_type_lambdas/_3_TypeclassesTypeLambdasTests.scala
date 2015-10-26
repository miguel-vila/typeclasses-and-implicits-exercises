package typeclasses_and_implicits.exercises._3_typeclasses_and_type_lambdas

import org.scalatest._
import Mappable._

class _3_TypeclassesTypeLambdasTests extends FlatSpec with Matchers {

  "3. TypeclassesTypeLambdas" should "implement exercise 3.1" in {
    """
      |ListOfOptionsMappable.map( List(Some(1), None, Some(2)) )(_ + 1)
    """.stripMargin should compile
  }

  it should "implement exercise 3.2" in {
    """
      |OptionMappable.compose(OptionMappable).map( Some(Some(1)) )(_ + 1)
    """.stripMargin should compile
  }

  it should "implement exercise 3.3" in {
    """
      |ListOfOptionsMappable2.map( List(Some(1), None, Some(2)) )(_ + 1)
    """.stripMargin should compile
  }

}
