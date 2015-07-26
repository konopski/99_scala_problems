package konopski.ninety.nine { 
  object p05 {
def reverse[A](in: List[A]) = {

  def rev[A](in: List[A], out: List[A]): List[A] = {
    if(in.isEmpty) out
    else rev(in.tail, out :+ in.head) 
  }

 
  if(in.isEmpty) in 
  else rev(in.tail, List(in.head))
}

println(reverse(List(1, 1, 2, 3, 5, 8)))
  }
}
