package konopski.ninety.nine {

import S99Int._

object P46 extends App {

  def nand(p: Boolean, q: Boolean) = (p, q) match {
    case (true, true) => false
    case (_, _) => true
  }

  def not(p: Boolean) = nand(p, p)

  def and(p: Boolean, q: Boolean) = not(nand(p, q))

  def or(p: Boolean, q: Boolean) = nand(not(p), not(q))
  
  def xor(p: Boolean, q: Boolean) = or(and(not(p), q), and(p, not(q)))
  
  def equ(p: Boolean, q: Boolean) = not(xor(p, q))

  def impl(p: Boolean, q: Boolean) = nand(p, not(q))



  def table(f: (Boolean, Boolean) => Boolean ) = {
    println("A\tB\tresult")
    val truths = 
         for { a <- List(true, false)
               b <- List(true, false)
         } yield "%b\t%b\t%b".format(a,b,f(a,b))

    truths foreach println
  }

  table(impl)

}

}
