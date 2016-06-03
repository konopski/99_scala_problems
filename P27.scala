package konopski.ninety.nine {
import Permutations.{ perms => permutations }
import P17._

object P27 extends App {

 def group3[T](l: List[T])= { //: List[List[List[T]]] = {
   val groupCount = 3
   val sizes = List(2,3,4)
   val r = permutations(l) map { p => 
       sizes.foldLeft( (List[List[T]](), p) ) { (a, n ) => 
         val x = split(n, a._2)
         (a._1 :+ x._1, x._2) 
       }._1
   } 
   r
 }
  
//println(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))) 
(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))) foreach println 

}

}
