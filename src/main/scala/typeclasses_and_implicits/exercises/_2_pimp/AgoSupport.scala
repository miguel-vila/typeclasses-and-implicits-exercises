package typeclasses_and_implicits.exercises._2_pimp

import scala.concurrent.duration._
import org.joda.time.DateTime

/**
 * Ejercicio 2.1
 *
 * Escribir código que permita llamar un método llamado  ago
 * sobre objetos de tipo  FiniteDuration
 *
 * Algunas ayudas:
 *
 * - Usando la clase DateTime de JodaTime
 * - DateTime.now() devuelve el momento actual
 * - El método minusMillis de DateTime​
 *
 * Al final se debe poder escribir código como el siguiente:
 *
 * 1.minute.ago
 * 3.hours.ago
 */
object AgoSupport {

  class WithAgo(d: FiniteDuration) {

    def ago() = {
      val now = DateTime.now()
      now.minusMillis( d.toMillis.toInt )
    }

  }

  implicit def toWithAgo(d: FiniteDuration) = new WithAgo(d)

}
