package konopski.ninety.nine {

  import scala.annotation.tailrec


  object P50 extends App {

    def huffman[T](histogram: List[(T, Int)]) = {
      import P28.sort
      import P20.removeAt

      case class Info(symbols: List[T], weight: Int)

      def info( symbolAndWeight: Pair[T,Int] ) = Info(List(symbolAndWeight._1), symbolAndWeight._2)
      def destr(info: Info) = (info.symbols.head, info.weight.toString)

      class Elem(val info: Info)
      case class NonLeaf(override val info: Info, left: Elem, right: Elem) extends Elem(info)
      case class Leaf(override val info: Info) extends Elem(info)

      def merge(left: Elem, right: Elem) = NonLeaf(
        Info(left.info.symbols ++ right.info.symbols, left.info.weight + right.info.weight), left, right)

      def cmp = { (l: Info, r: Info) => l.weight <= r.weight }

      def cmpElem = { (l: Elem, r: Elem) => cmp(l.info, r.info) }

      def minElem(elems: List[Elem]) = min(cmpElem)(elems)


      @tailrec
      def mkTree(in: List[Elem]): List[Elem] = {
        if(in.size <= 1) in
        else {
          minElem(in) match {
            case None => in
            case Some((minimal, index)) => {
              val nextIn = removeAt(index, in)
              minElem(nextIn) match {
                case None => in
                case Some((nextMinimal, nextIndex)) => {
                  val extracted: List[Elem] = removeAt(nextIndex, nextIn)
                  val addMe = merge(minimal, nextMinimal)
                  mkTree( addMe :: extracted )
                }
              }
            }
          }
        }
      }

      val input = sort(histogram map { info }, cmp ) map { Leaf }
      mkTree( input )
    }

 //   println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))))
    println(huffman(List(("a", 8), ("b", 3), ("c", 1), ("d", 1), ("e", 1), ("f", 1), ("g", 1), ("h", 1))))

    def min[K]( lt: (K, K) => Boolean)(elems: List[K]): Option[(K, Int)] = {

      val empty: Option[(K, Int)] = None
      elems.zipWithIndex.foldLeft(empty) {
        (acc: Option[(K, Int)], checkMe: (K, Int)) =>
          acc match {
            case None =>
              Some((checkMe._1, checkMe._2))
            case Some((minimum, minIdx)) =>
              if (lt(checkMe._1, minimum)) Some((checkMe._1, checkMe._2))
              else Some((minimum, minIdx))
          }
      }
    }

//     println( min( (l: Int, r: Int) => l < r)( List(5,4,6,2,3) ) )

  }


}
