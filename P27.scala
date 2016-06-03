package konopski.ninety.nine {
import Permutations.{ perms => permutations }
import P17._

object P27 extends App {

 def group3[T](l: List[T])= { //: List[List[List[T]]] = {
   val groupCount = 3
   val sizes = List(2,3,4)
   val r = permutations(l) map { p => 
      sizes map { n => split(n, p) } 
   } 
   //List(r(0))
   r
 }
  
//println(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))) 
//(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))) foreach println 

  val l = List("a", "b", "c", "d", "e", "f", "g", "h", "i") 
  val s = List(2,3,4)
                                               
/*
  println( s.foldLeft(0) { (acc: Int, x: Int) => acc + x })
  def sumuj(x: Int, acc: Int): Int = x + acc
  println( s.foldLeft(0)(sumuj))
*/

   val e = List[List[String]]()
   val res = s.foldLeft(( (e, l), 0)) { (a, b ) => 
     val n = a._2 + b
     println(b)
     println(n)
     //    (a._1._1 :+ firstN(n, fromN(a._2, l)) , n) 
     println(split(b, a._1._2))
     ((a._1._1, a._1._2) , n)
   }._1
   
   println(res)
}

}
