package konopski.ninety.nine {

import P20._
import scala.util.Random

object P23 extends App {
  lazy val r = new Random

  def randomSelect[T](n: Int, list: List[T]) : List[T] = {
    if(n<=0 || list.isEmpty) List()
    else  { 
      val afterRemove = removeAt(r.nextInt(list.size), list)
      afterRemove._2 :: randomSelect(n - 1, afterRemove._1)
    }
  } 
  
  println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))

}

}
