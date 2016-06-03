package konopski.ninety.nine {
import Permutations.{ perms => permutations }
import P17._

object P27 extends App {

 def group3[T](l: List[T])= { //: List[List[List[T]]] = {
   val sizes = List(2,3,4)
   group(sizes, l)
 }

 def group[T](sizes: List[Int], l: List[T]) = {
   permutations(l) map { p => 
       sizes.foldLeft( (List[List[T]](), p) ) { (a, n ) => 
         val x = split(n, a._2)
         (a._1 :+ x._1, x._2) 
       }._1
   } 
 }
  
//println(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))) 
(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))) foreach println 

}

}
