package konopski.ninety.nine { 
  object p01 {
def last[A](in: List[A]): A = {
  def l[A](in: List[A], el: A): A = {
    if(in.isEmpty) el
    else l(in.tail, in.head)
  }
  if(in.isEmpty) throw new IllegalArgumentException
  else l(in.tail, in.head) 
}

println (last(List(1, 1, 2, 3, 5, 8)))
  }
}
