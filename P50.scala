package konopski.ninety.nine {

  import scala.annotation.tailrec


  object P50 extends App {

    def huffman[T](histogram: List[(T, Int)], text: List[T] = List()) = {
      import P20.removeAt

      case class Info(symbols: List[T], weight: Int)

      def info( symbolAndWeight: Pair[T,Int] ) = Info(List(symbolAndWeight._1), symbolAndWeight._2)

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
        else minElem(in) match {
          case None => in
          case Some((minimal, index)) =>
            val nextIn = removeAt(index, in)
            minElem(nextIn) match {
              case None => in
              case Some((nextMinimal, nextIndex)) =>
                val addMe = merge(minimal, nextMinimal)
                mkTree( addMe :: removeAt(nextIndex, nextIn))
            }
        }
      }

      val input = histogram map { info } map { Leaf }
      val huffmanTree = mkTree  ( input )


      def searchInTree(tree: Elem, symbol: T) = {

        def search(acc: (String, Boolean), current: Elem): (String, Boolean) = {
          current match {
            case Leaf(info) =>
              if(info.symbols.head == symbol) (acc._1, true)
              else (acc._1, false)
            case NonLeaf(info, left, right) =>
              val resultFromLeft = search( ("", false), left)
              if(resultFromLeft._2) ("0".concat(resultFromLeft._1), true)
              else {
                val resultFromRight = search( (resultFromLeft._1, true), right)
                if(resultFromRight._2) ("1".concat(resultFromRight._1), true)
                else acc
              }
          }
        }

        search(("", false), tree)._1
      }

      val codeMe =
        if(text.isEmpty) histogram.unzip._1
        else text

      val res = for {
          symbol <- codeMe
          tree <- huffmanTree
        } yield searchInTree(tree, symbol)

      codeMe zip res
    }

    println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))))

    println(huffman(List(
      ("a",5),
      ("b",9),
      ("c",12),
      ("d",13),
      ("e",16),
      ("f",45)
    )))

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
