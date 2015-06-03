package konopski.ninety.nine { 
  object p06 {
  import p05._
  import p06._
  import p04._
  import p03._
//run: scala -i p05.scala -i p04.scala -i p03.scala  p06.scala

def isPalindrome[A](in: List[A]): Boolean = {
  val reversed = reverse(in)
  val len = length(in)
  for(i <- 0 until len ) {
    if(nth(i, in) != nth(i, reversed)) return false     
  }
  true
} 



isPalindrome(List(1, 2, 3, 2, 1))
  }
}
