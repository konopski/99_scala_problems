package konopski.ninety.nine { 
  object p09 {
def pack[A](list: List[A]) = {
 
  List()
}


val result = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
println(result)
println(result == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))

  }
}
