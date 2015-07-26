object P16 extends App {

  def drop[T](n: Int, list: List[T]) = {

    list.zipWithIndex
      .filterNot( (p) => (p._2 + 1) % n == 0 )
      .unzip._1
  }

  println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'l)))

}

