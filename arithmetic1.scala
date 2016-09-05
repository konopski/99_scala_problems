package konopski.ninety.nine {

  class S99Int(val start: Int) {
    import S99Int._

    def isPrime = {
      (2 until this.start filter { this.start % _ == 0 }).length == 0 
    } 

    def isCoprimeTo(i: Int) = {
      P32.gcd(this.start, i) == 1
    }

    def primeFactors = {
      val primes = (2 until this.start) filter { _.isPrime }
      def banglaj(x: Int, l: List[Int]): Seq[Int] = {
        val nc = primes filter { _ <= x } filter { x % _ == 0 }
        if (nc.isEmpty) l
        else banglaj( x / nc(0), l :+ nc(0) )
      }
      banglaj(this.start, List())
    }

    def totient = {
        (1 to this.start filter { _.isCoprimeTo(this.start) } ).length   
    }
  }

  object S99Int { 
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
