package konopski.ninety.nine {
object P18 extends App {

  def slice[T](i: Int, k: Int, list: List[T]) = 
    list
     .zipWithIndex
     .filter( (p) => p._2 < k )
     .filter( (p) => p._2 >= i )
     .unzip._1
  
  println(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

}

}
