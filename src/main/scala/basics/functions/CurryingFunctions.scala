package functions

/**
  * Created by moussi on 15/07/18.
  */
object CurryingFunctions {

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }

  def factorial(a: Int): Int = {
    product2(x => x)(1, a)
  }

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  }


  /**
    * Combine Sum and product function in one fuction mapReduce by currying
    *
    * @param f
    * @param combiner
    * @param zero
    * @param a
    * @param b
    * @return
    */
  def mapReduce(f: Int => Int, combiner: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combiner(f(a), mapReduce(f, combiner, zero)(a + 1, b))
  }

  def sum2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)

  def product2(f: Int => Int)(a: Int, b: Int) = mapReduce(f, (x, y) => x * y, 1)(a, b)

  def main(args: Array[String]): Unit = {
    println("Product = " + product(x => x * x)(3, 4))
    println("Combined Product = " + product2(x => x * x)(3, 4))
    println("Facorial with combined func = " + factorial(4))
    println(sum2(x => x)(3, 5))
  }

}
