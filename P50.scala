package konopski.ninety.nine {

import S99Int._

object P50 extends App {

  def huffman[T](histogram: List[(T, Int)]) = {
     import P28.sort 
     
     case class Info(symbols: List[T], weight: Int)

     def info( symbolAndWeight: Pair[T,Int] ) = Info(List(symbolAndWeight._1), symbolAndWeight._2)
     def destr(info: Info) = (info.symbols.head, info.weight.toString)

     class Elem(val info: Info) 
     case class NonLeaf(override val info: Info, left: Elem, right: Elem) extends Elem(info)
     case class Leaf(override val info: Info) extends Elem(info)
     
     def merge(left: Elem, right: Elem) = NonLeaf(Info(left.info.symbols ++ right.info.symbols, left.info.weight + right.info.weight), left, right)

     
     val input = sort(histogram map { info }, { (l: Info, r: Info) => l.weight >= r.weight } ) map { Leaf }
    
     input

  }

  println( huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))) )

  def min[T](elems: List[T], lt: (T,T) => Boolean ) = {
    abstract class SearchStep
    case class NoMinFound extends SearchStep
    case class FoundMin(minimum: T, minIdx: Int) extends SearchStep
    
    val empty: SearchStep = NoMinFound()
    (elems.zipWithIndex).foldLeft(empty) {
      (acc: SearchStep, checkMe: (T, Int) ) =>
        acc match {
          case NoMinFound() =>
            FoundMin(checkMe._1, checkMe._2)
          case FoundMin(minimum, minIdx) =>
            if( lt(checkMe._1, minimum) ) FoundMin(checkMe._1, checkMe._2)
            else FoundMin(minimum, minIdx)
        }
    }
  }

  // println( min( List(5,4,6,2,3), (l: Int, r: Int) => l < r ) )
}


}
