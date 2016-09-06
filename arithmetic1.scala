package konopski.ninety.nine {

  class S99Int(val start: Int) {
    import S99Int._
    import P10._
    import P32._

    def isPrime() = {
      (2 until this.start filter { this.start % _ == 0 }).length == 0 
    } 

    def isCoprimeTo(i: Int) = {
      gcd(this.start, i) == 1
    }

    def primeFactors(): List[Int] = {
      val primes = (2 until this.start) filter { _.isPrime }
      def banglaj(x: Int, l: List[Int]): List[Int] = {
        val nc = primes filter { _ <= x } filter { x % _ == 0 }
        if (nc.isEmpty) l
        else banglaj( x / nc(0), l :+ nc(0) )
      }
      banglaj(this.start, List())
    } 
    
    def primeFactorsMultiplicity() = encode(primeFactors()) 

    def primeFactorsMultiplicityAsMap() = {
      primeFactorsMultiplicity() map { Map(_) }
    }
  
    def totient() = {
        (1 to this.start filter { _.isCoprimeTo(this.start) } ).length   
    }
  }

  object S99Int { 
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
