package functions

import java.lang.Math.abs

/**
  * Created by moussi on 15/07/18.
  */
object FixedPointExample {

  val tolerance = 0.0001
  def isCloseEnough(x:Double, y:Double) = {
    abs((x-y)/x)/x < tolerance
  }

  def fixedPoint(f: Double => Double)(firstGuess:Double) = {
    def iterate(guess:Double):Double = {
      val next = f(guess)
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def sqrt(x:Int) = fixedPoint(y => x/y)(1.0)

  def main(args: Array[String]): Unit = {
    println(fixedPoint(x => 1 + (x/2))(2))
    println(sqrt(4))
  }
}
