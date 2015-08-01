package konopski.ninety.nine {

import P17._

object P19 extends App {

  def rotate[T](n: Int, list: List[T]) = {
    val N = if (n < 0) list.size + n else n
    val (l, r) = split(N, list)
    r ++ l
  } 
  
  println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

  println(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

}

}
