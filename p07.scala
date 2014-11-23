def flatten(in: List[Any]): List[Any]= {
  def flatten0(in: List[Any], acc: List[Any]): List[Any] = {
    if(in.isEmpty) acc
    else {
      in.head match {
        case inside: List[Any] => flatten0(in.tail, acc ++ flatten(inside))
        case _ => flatten0(in.tail, acc :+ in.head)
      }
    }
  } 
  flatten0(in, List()) 
} 

println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
