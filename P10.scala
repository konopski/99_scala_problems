package konopski.ninety.nine {
object P10 extends App {
import P09._

  def encode[T](list: List[T]) = {

    pack(list) map { l => (l.size, l.head) }
  } 

 println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

}
}
