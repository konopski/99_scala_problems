package konopski.ninety.nine {

  class S99Int(val start: Int) {
    import S99Int._


    def isCoprimeTo(i: Int) = {
      P32.gcd(this.start, i) == 1
    }
  }

  object S99Int { 
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
