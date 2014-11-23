def penultimate[A](in : List[A] ) = {
  def p[A](in: List[A], prev: A) : A = {
    if(in.tail.isEmpty) prev
    else p(in.tail, in.head) 
  }
  if(in.isEmpty || in.tail.isEmpty) throw new IllegalArgumentException
  else p(in.tail, in.head)
}

println(penultimate(List(1, 1, 2, 3, 5, 8)))
