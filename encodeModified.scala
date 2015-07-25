object P11 extends App {
import P10._

  def encodeModified[T](list: List[T]): List[Any] = {
    for( (size, elem) <- encode(list) )    
       yield if (size == 1) elem
             else (size, elem)
       
  }

 println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

}
