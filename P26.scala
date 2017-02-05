package konopski.ninety.nine {

object P26 extends App {

  def combinations[T](n: Int, list: List[T]): List[List[T]] = {
    if(list.isEmpty || n==0 ) List()
    else {
      if(n==1) list map { List(_) }
      else { 

        //combinations n xs = head [ (++) (map (x:) (combinations (n-1) (filter (/=x) xs) )) (combinations n (filter (/=x) xs)) | x <- xs ]

        val empty: List[List[T]] = List()
        list.foldLeft(empty) {(ac, x) =>
          
           ((combinations(n-1, list filter { _ != x})) map {
             l: List[T] => x::l 
           } )++ (combinations(n, list filter { _ != x}))
        }
      } 
    }
  } 
  
println( combinations(2, List('a, 'b, 'c, 'd)))

}

}
