package konopski.ninety.nine {

import S99Int._

object P42 extends App {


  def and(p: Boolean, q: Boolean) = if (p) q else p

  def or(p: Boolean, q: Boolean) = if (p) true else q

  def not(p: Boolean) = if (!p) true else false 

  def nand(p: Boolean, q: Boolean) = not(and(p, q))

  def nandP(p: Boolean, q: Boolean) = if(p && q) false else true

  println(not(and(true, true)))
  println(or(false, true))


  def table(f: (Boolean, Boolean) => Boolean ) = {
    println("A\tB\tresult")
    val truths = 
         for { a <- List(true, false)
               b <- List(true, false)
         } yield "%b\t%b\t%b".format(a,b,f(a,b))

    truths foreach println
  }

  table(nand)
  table(nandP)
}

}
