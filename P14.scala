object P14 extends App {

  def duplicate[T](list: List[T]): List[T] = {
    list flatMap { el => List(el, el) }
  }

  println(duplicate(List('a, 'b, 'c, 'c, 'd)))

}

