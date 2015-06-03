package konopski.ninety.nine { 
  object p03 {
def nth[A](k:Int, in : List[A]): A = {
  if(k==0) in.head
  else nth(k-1, in.tail)
}

println(nth(2, List(1, 1, 2, 3, 5, 8)))
  }
}
