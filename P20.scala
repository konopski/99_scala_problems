package konopski.ninety.nine {
import p03._
object P20 extends App {

  def removeAt[T](n: Int, list: List[T]) = {
    (
        list
        .zipWithIndex
        .filter( (p) => p._2 != n )
        .unzip._1 ,
        nth(n, list)
    )
  }
  
  println(removeAt(1, List('a, 'b, 'c, 'd)))

}

}
