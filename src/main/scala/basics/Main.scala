package basics

import scala.annotation.tailrec

/**
  * Created by moussi on 07/07/18.
  */
object Main extends App {

  def fact(a: Int): Int = {
    if (a == 0) 1
    else
      a * fact(a - 1)
  }

  def tailFact(a: Int) = {
    @tailrec
    def loop(acc: Int, a: Int): Int = {
      if (a == 0) acc
      else
        loop(acc * a, a - 1)
    }

    loop(1, a)
  }

  def power(a: Int, b: Int): Int = {
    if (b == 0) 1
    else
      a * power(a, b - 1)
  }

  def tailPower(a: Int, b: Int) = {
    @tailrec
    def loop(acc: Int, a: Int, b: Int): Int = {
      if (b == 0) acc
      else
        loop(acc * a, a, b - 1)
    }

    loop(1, a, b)
  }

  @tailrec
  def pgcd(a: Int, b: Int): Int = {
    if (b == 0) a else pgcd(b, a % b)
  }

  println(fact(5))
  println(tailFact(5))
  println(power(5, 0))
  println(tailPower(5, 0))
  println(pgcd(14, 21))
}
