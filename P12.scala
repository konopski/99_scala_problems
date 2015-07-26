package konopski.ninety.nine {
object P12 extends App {

  def decode[T](list: List[(Int, T)]): List[T] = {
    list flatMap (el => {
      1 to el._1 map { _ => el._2 }
    })
  }

  println(decode(List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))))

}
}
