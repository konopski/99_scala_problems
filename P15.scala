package konopski.ninety.nine {
object P15  extends App {

  def duplicateN[T](n: Int, list: List[T]): List[T] = {
    list flatMap { el => (1 to n).toList flatMap { e => List(el) } }
  }

  println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))

}
}
