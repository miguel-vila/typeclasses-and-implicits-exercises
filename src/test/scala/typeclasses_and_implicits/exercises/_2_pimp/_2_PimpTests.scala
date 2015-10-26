package typeclasses_and_implicits.exercises._2_pimp

import org.scalatest._
import scala.concurrent.duration._

class _2_PimpTests extends FlatSpec with Matchers {
  import AgoSupport._

  "2. Pimp" should "allow to call ago in FiniteDuration objects (exercise 2.1)" in {
    """
      |val a: org.joda.time.DateTime = 1.minute.ago
      |val b: org.joda.time.DateTime = 5.hours.ago
      |val c: org.joda.time.DateTime = 3.days.ago
    """.stripMargin should compile
  }

}
