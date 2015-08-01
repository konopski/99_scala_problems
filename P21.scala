package konopski.ninety.nine {

import P17._

object P21 extends App {

  def insertAt[T](el: T, n: Int, list: List[T]) = {
    val (l, r) = split(n, list)
    l ++ ( el :: r )
  } 
  
  println(insertAt('new, 1, List('a, 'b, 'c, 'd)))

}

}
