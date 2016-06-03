package konopski.ninety.nine {

/*
scala port of 6 lines haskell code 
from Graham Hutton's book
see countdown code example chapter 11
http://www.cs.nott.ac.uk/~pszgmh/book.html

> interleave                    :: a -> [a] -> [[a]]
> interleave x []               =  [[x]]
> interleave x (y:ys)           =  (x:y:ys) : map (y:) (interleave x ys)
> 
> perms                         :: [a] -> [[a]]
> perms []                      =  [[]]
> perms (x:xs)                  =  concat (map (interleave x) (perms xs))

*/

object Permutations {

  def interleave[T](x: T)(list: List[T]): List[List[T]] = {
    list match {
      case List() => List(List(x))
      case y::ys => (x::y::ys) :: (interleave(x)(ys) map { y::_ }) 
    }
  }

  def perms[T](list: List[T]):List[List[T]] = {
    list match {
      case List() => List(List())
      case x::xs  => perms(xs) flatMap { ps => interleave(x)(ps) } 
    }
  } 

}

}
