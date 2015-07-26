package konopski.ninety.nine { 
	object P09 extends App{

	 def pack[T](list: List[T]): List[List[T]] = {

	  def last[T] (l: List[T]) = l.reverse.head

	  def replaceLast[T] (l: List[List[T]], elem: List[T]) = (elem :: l.reverse.tail).reverse

	  def p0[T](acc: List[List[T]], l: List[T]) : List[List[T]] = {
	    if(l.isEmpty) acc
	    else {
		val previousElems = last(acc)        
		if(previousElems.head == l.head) {
		    p0(replaceLast(acc, previousElems ++ List(l.head) ), l.tail)
		} else {
		    p0(acc ++ List(List(l.head)), l.tail)
		}      
	    }
	  }  

	  if(list.isEmpty) List()
	  else p0(List(List(list.head)), list.tail) 

	 }

	 println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

	}
}
