package konopski.ninety.nine {
object P17 extends App {

  def firstN[T](n: Int, list: List[T]) = 
    list.zipWithIndex.filter( (p) => p._2 < n ).unzip._1
  
  def fromN[T](n: Int, list: List[T]) = 
    list.zipWithIndex.filter( (p) => p._2 >= n ).unzip._1
  
  def split[T](n: Int, list: List[T]) = (firstN(n, list), fromN(n, list))

  println(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

}

}
