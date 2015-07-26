package konopski.ninety.nine {
object P13 extends App {
	
  def encodeDirect[T](list: List[T]) = {

    def oneOrTwoPairs(l: (Int, T), r: (Int, T)): List[(Int, T)] = {
      if(l._2 == r._2) List((l._1 + r._1, l._2))
      else List(l, r)
    }

    def last[A](l: List[A]) = l.last

    val empty: List[(Int, T)] = List()

    if(list.isEmpty) empty
    else (list map { elem => (1, elem) }).foldLeft(empty){
      (ac, next) =>
        if(ac.isEmpty) List(next)
        else ac.reverse.tail.reverse ++ oneOrTwoPairs(last(ac), next)
    }
  }


 println(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

}
}
