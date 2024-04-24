package Lesson6.examples

object Polynomials {
  class Poly(val terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
    val terms: Map[Int, Double] = terms0 withDefaultValue 0.0
    def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
    private def adjust(term: (Int, Double)): (Int, Double) = {
      val (exp, coeff) = term
      exp -> (coeff + terms(exp))
    }
    override def toString: String =
      (for ((exp, coeff) <- terms.toList.sorted) yield coeff + "x^" + exp) mkString " + "
  }
}
