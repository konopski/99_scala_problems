package konopski.ninety.nine {
import Permutations.{ perms => permutations }
import P17._

object P27 extends App {

 def group3[T](l: List[T])= { 
   val sizes = List(2,3,4)
   group(sizes, l)
 }

 def group[T](sizes: List[Int], l: List[T]) = {
   def fltr[T](in: List[List[List[T]]]) = {
     val s = (in map { groups =>
        groups map { groupAsList => groupAsList.toSet }
     }).toSet
     (s map { groups =>
        groups map { groupAsSet => groupAsSet.toList }
     }).toList
   }

   val r = permutations(l) map { p => 
       sizes.foldLeft( (List[List[T]](), p) ) { (a, n ) => 
         val x = split(n, a._2)
         (a._1 :+ x._1, x._2) 
       }._1
   }
   fltr(r)

 }
  
//println(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))) 
(group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))) foreach println 

}

}
