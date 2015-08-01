package konopski.ninety.nine {

import P22._
import P23._

object P25 extends App {

  def randomPermute[T](list: List[T]) = {
     randomSelect(list.size, list)
  } 
  
println( randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))

}

}
