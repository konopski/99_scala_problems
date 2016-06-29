package konopski.ninety.nine {

object P32 extends App {

  def gcd(l: Int, r: Int): Int = {
    var a = l
    var b = r

    while(b!=0) {
      var c = a % b
      a = b
      b = c 
    }
    a
  }

println(gcd(36,63))

}

}
