package konopski.ninety.nine { 
  object p08 {
def compress[A](list: List[A]) = {
  def compr1(list: List[A], prev: A, acc: List[A]): List[A]= {
    if(list.isEmpty) acc 
    else {
      if(list.head == prev) compr1(list.tail, prev, acc)
      else compr1(list.tail, list.head, acc :+ list.head)
    }
  }
  
  if(list.isEmpty) list
  else compr1(list.tail, list.head, List(list.head))
}


println( compress(List('a)) )
println( compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) )
  }
}
