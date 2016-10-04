package konopski.ninety.nine {

import S99Int._

object P41 extends App {


  def fmt(g: Pair[Int, Pair[Int, Int]]) = {
    "%d = %d + %d".format(g._1, g._2._1, g._2._2)
  }

  def goldbachList(intz: Range) = {
      val evens = intz filter { _ % 2 == 0 } 
      evens map { x => (x, x.goldbach.head) }
  }

  def printGoldbachList(intz: Range) = {
      val gs = goldbachList(intz)
      gs foreach { { g => println(fmt(g)) } }
  }

  def goldbachListLimited(intz: Range, limit: Int) = {
      goldbachList(intz).filter { g => (g._2._1 > limit) && (g._2._2 > limit) }
  }

  def printGoldbachListLimited(intz: Range, limit: Int) = {
      val gs = goldbachListLimited(intz, limit)
      gs foreach { { g => println(fmt(g)) } }
  }

  printGoldbachList(9 to 20)
  printGoldbachListLimited(990 to 1000, 50)


}

}
