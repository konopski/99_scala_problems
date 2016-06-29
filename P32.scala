package konopski.ninety.nine {

object P32 extends App {

  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = {
    if(b!=0) 
      gcd(b, a % b) 
    else 
      a
  }

  println(gcd(36,63))

}

}
