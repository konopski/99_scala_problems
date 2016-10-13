package konopski.ninety.nine { 
  object p05 {
def reverse[A](in: List[A]) = {
  val empty: List[A] = List()
  in.foldLeft (empty) { (acc: List[A], el: A) => el :: acc }
}

println(reverse(List(1, 1, 2, 3, 5, 8)))
  }
}
