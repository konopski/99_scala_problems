package konopski.ninety.nine {

object P28 extends App {

  private def sort[T](lists: List[T], lteq: (T,T) => Boolean): List[T] = { 
    lists match { 
      case x::xs =>  sort(xs.filter( { y:T => lteq(y, x) }), lteq)  ++ List( x ) ++  sort(xs.filter( { y:T => !lteq(y, x) }), lteq) 
      case List() => List()
    }
  }

  def le[T] = {(x: (List[T], Int), y: (List[T], Int)) => x._2 <= y._2 }

  def lsort[T](lists: List[List[T]]) = { 
    sort(lists map { l => (l, l.size) }, le).unzip._1
  }

  def lsortFreq[T](lists: List[List[T]]) = { 
    val sized = lists map { l => (l, l.size) }
    val sizeFreq = sized map { e => (e._2, sized.count( _._2 == e._2 )) } 
    val sf = sized map { l => (l._1, sizeFreq.find(_._1 == l._2).get._2) }
    sort(sf, le).unzip._1
  }

  
lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) foreach println 

println

lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) foreach println 
}

}
