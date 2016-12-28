package konopski.ninety.nine {

import S99Int._

object P50 extends App {

  def huffman[T](histogram: List[(T, Int)]) = {
     import P28.sort 
     
     case class Info(symbols: List[T], weight: Int)

     def info( symbolAndWeight: Pair[T,Int] ) = Info(List(symbolAndWeight._1), symbolAndWeight._2)
     def destr(info: Info) = (info.symbols.head, info.weight.toString)

     class Elem 
     case class NonLeaf(weight: Int, symbols: List[T], left: Elem, right: Elem) extends Elem
     case class Leaf(weight: Int, symbol: T) extends Elem
     
     
     
     //sort(histogram, { (x: (T, Int), y: (T, Int)) => x._2 >= y._2 } ) map { info } map { destr } //{ el => (el._1, el._2.toString) }

     sort(histogram map { info }, { (l: Info, r: Info) => l.weight >= r.weight } ) map { destr }
  }

  println( huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))) )

}


}
