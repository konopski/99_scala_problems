package konopski.ninety.nine {

import S99Int._

object P39 extends App {

  def listPrimesInRange(r: Range) = {
    r filter { _.isPrime }
  }
  println(listPrimesInRange(7 to 31))

}

}
