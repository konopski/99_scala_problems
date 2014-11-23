def length[A](in: List[A]) = {
  
  def l[A](in: List[A], cnt: Int): Int = {
    if(in.isEmpty) cnt
    else l(in.tail, cnt + 1)
  } 
  l(in, 0)
}

print(length(List(1, 1, 2, 3, 5, 8)))
