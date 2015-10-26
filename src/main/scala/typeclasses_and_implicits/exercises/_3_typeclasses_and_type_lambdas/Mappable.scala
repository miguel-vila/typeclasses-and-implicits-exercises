package typeclasses_and_implicits.exercises._3_typeclasses_and_type_lambdas

trait Mappable[F[_]] { self =>

  def map[A,B](fa: F[A])(f: A => B): F[B]

  /**
   * Ejercicio 3.2
   * Generalizar el patrón de componer un [Mappable] dentro de otro [Mappable]
   * para crear un tercero.
   *
   * Debe ser un método definido dentro de la  typeclass [Mappable] que reciba
   * otro [Mappable] y devuelva la composición.
   *
   * Ayudas:
   * - Primero es sugerible definir cual es el tipo del [Mappable] resultante
   *   de la composición. En este caso será necesario usar la sintáxis Lambda[ X => ... ]
   *
   * - Una vez definido el tipo la idea es instanciar un [Mappable] de ese tipo.
   *   Para esto será necesario implementar el método .map . La implementación
   *   será similar a la del anterior punto.
   *
   * - Utilizar la referencia a self (que referencia el [Mappable] actual) para
   *   llamar .map en el contexto del nuevo [Mappable] sin que haya ambigüedad sobre
   *   qué metodo se quiere llamar
   */
  //def compose[G[_]](implicit other: Mappable[G]): Mappable[ ??? ] = { ... }

}

object Mappable {

  /**
   * Método utilitario para encontrar implícitos de [Mappable]s
   */
  def apply[F[_]](implicit m: Mappable[F]): Mappable[F] = m

  implicit object ListMappable extends Mappable[List] {
    def map[A,B](la: List[A])(f: A => B): List[B] = {
      la.map(f)
    }
  }

  implicit object OptionMappable extends Mappable[Option] {
    def map[A,B](opt: Option[A])(f: A => B): Option[B] = {
      opt.map(f)
    }
  }

  /**
   * Ejercicio 3.1
   * Definir un  Mappable para las Listas de Options:
   * ListOfOptionsMappable.map( List(Some(1),None,Some(3)) )( _ + 1 ) == List(Some(2), None, Some(4))
   */
  implicit object ListOfOptionsMappable //extends Mappable[ ??? ] { ... }

  /**
   * Ejercicio 3.3
   * Utilizar la función definida en el ejercicio 2 para implementar
   * el [Mappable] del ejercicio 1
   */
  val ListOfOptionsMappable2 = ???

}