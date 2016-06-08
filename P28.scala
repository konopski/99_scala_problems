package konopski.ninety.nine {

object P28 extends App {

  private def sort[T](lists: List[T], lteq: (T,T) => Boolean): List[T] = { 
    lists match { 
      case x::xs =>  sort(xs.filter( { y:T => lteq(y, x) }), lteq)  ++ List( x ) ++  sort(xs.filter( { y:T => !lteq(y, x) }), lteq) 
      case List() => List()
    }
  }

  def lsort[T](lists: List[List[T]]) = { 
    sort(lists map { l => (l, l.size) }, {(x: (List[T], Int), y: (List[T], Int)) => x._2 <= y._2 }).unzip._1
  }

  
lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) foreach println 

}

}
