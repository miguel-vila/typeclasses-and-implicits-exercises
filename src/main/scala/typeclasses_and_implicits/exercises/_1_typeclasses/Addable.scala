package typeclasses_and_implicits.exercises._1_typeclasses

trait Addable[T] {
  def zero: T
  def add(a: T, b: T): T
}

object Addable {

  /**
   * Método utilitario para encontrar implícitos de [Addable]s
   */
  def apply[T](implicit addable: Addable[T]) = addable

  implicit object IntAddable extends Addable[Int] {
    override def zero: Int = 0

    override def add(a: Int, b: Int): Int = a+b
  }

  implicit object StringAddable extends Addable[String] {
    override def zero: String = ""

    override def add(a: String, b: String): String = a concat b
  }

  /**
   * Ejercicio 1.1
   * Definir un método addAll que reciba una lista de T's en
   * el  typeclass Addable y que devuelva la "sumatoria" de
   * todos los elementos.
   *
   * Por ejemplo al invocarla con:
   * addAll( List(4,10,7,5) )
   * debería arrojar el mismo resultado que:
   * 0 + 4 + 10 + 7 + 5
   */
  def addAll[T](ts: List[T])(implicit addable: Addable[T]): T = {
    ts.foldLeft(addable.zero)(addable.add)
  }

  /**
   * Ejercicio 1.2
   * Defina una función implícita que reciba, implícitamente 2 Addables y
   * devuelva un Addable de tuplas de 2 elementos donde el primer elemento
   * es del tipo del primer Addable y el segundo elemento es del tipo del
   * segundo Addable.
   *
   * En otras palabras una función con esta firma:
   */
  implicit def product[S,T](implicit addS: Addable[S], addT: Addable[T]): Addable[(S,T)] =
    new Addable[(S,T)] {
      def zero = (addS.zero, addT.zero)
      def add(a: (S,T), b: (S,T)): (S,T) = (a,b) match {
        case ((aS,aT),(bS,bT)) => (addS.add(aS,bS), addT.add(aT,bT))
      }
    }

}