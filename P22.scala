package konopski.ninety.nine {

import P17._

object P22 extends App {

  def range[T](i: Int, k: Int) : List[Int] = {
    if (i > k) List()
    else i :: range(i + 1, k) 
  } 
	
  println( range(4, 9) )
}

}
