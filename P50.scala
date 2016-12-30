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


 def min[T](elems: List[T], lt: (T,T) => Boolean ): Int = {

   @annotation.tailrec
   def min0(l: List[T], at: Int, minIdx: Int, minimum: Option[T]): Int = {
     if(l.isEmpty) { minIdx }
     else {
       if(-1 == minIdx || lt(l.head, minimum.get) ) {
           min0(l.tail, at+1, at, Some(l.head))
       } else {
           min0(l.tail, at+1, minIdx, minimum)
       } 
     }
   }
   
   min0(elems, 0, -1, None)
 }

  // println( min( List(5,4,6,2,3), (l: Int, r: Int) => l < r ) )
}


}
