package konopski.ninety.nine {

import P22._
import P23._

object P24 extends App {

  def lotto(n: Int, m: Int) = {
     randomSelect(n, range(1, m))
  } 
  
  println(lotto(6, 49))

}

}
