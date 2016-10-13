package konopski.ninety.nine {

import S99Int._

object P49 extends App {

  def gray(n: Int): List[String] = {
    import p05.reverse

    n match {
      case 0 => List("0")
      case 1 => List("0", "1")
      case _ => (gray(n-1) map {"0" + _} ) ++ (reverse(gray(n-1)) map {"1" + _})
    }

  }

  println(gray(3))
}


}
