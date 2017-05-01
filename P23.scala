package konopski.ninety.nine {

import p03._
import P20._
import scala.util.Random

object P23 extends App {
  lazy val r = new Random

  def removeAtPlus[T](n: Int, l: List[T]) = (removeAt(n, l), nth(n, l))

  def randomSelect[T](n: Int, list: List[T]) : List[T] = {
    if(n<=0 || list.isEmpty) List()
    else  { 
      val afterRemove = removeAtPlus(r.nextInt(list.size), list)
      afterRemove._2 :: randomSelect(n - 1, afterRemove._1)
    }
  } 
  
  println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))

}

}
