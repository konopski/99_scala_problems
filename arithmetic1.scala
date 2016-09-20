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
    
    def primeFactorsMultiplicity() = {
      encode(primeFactors()) map { case (l,r) => (r, l) }
    }

    def primeFactorsMultiplicityAsMap() = {
      primeFactorsMultiplicity() map { Map(_) }
    }

    def phi() = {
      def powr(x: Int, n: Int): Int = { 
        if(n==0) 1
        else if (n==1) x
        else n*powr(x, n-1)
      }
      primeFactorsMultiplicity map { case (p,m) => (p - 1) * powr(p,m-1) } product
    }
    
  
    def totient() = {
        (1 to this.start filter { _.isCoprimeTo(this.start) } ).length   
    }

    def goldbach() = {
       import P39._
       for {
           s <- List(this.start) if this.start % 2 == 0
           x <- listPrimesInRange(2 to s) 
           y <- listPrimesInRange(x to s)
           if x + y == this.start
       } yield (x, y)
    }
  }

  object S99Int { 
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
