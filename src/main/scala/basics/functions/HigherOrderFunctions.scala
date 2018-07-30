package functions

/**
  * Created by moussi on 15/07/18.
  */
object HigherOrderFunctions{

  def sum(f: Int => Int)(a:Int, b:Int): Int ={
    def loop(a:Int, acc:Int): Int ={
      if(a>b) acc
      else loop(a+1, f(a) + acc)
    }
    loop(a, 0)
  }

  def main(args: Array[String]): Unit = {
    println(sum(x => x*x)(3,4))
    println(sum(x => x)(1,4))
  }


}
