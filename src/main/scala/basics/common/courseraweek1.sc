def abs(x:Double) = if(x>0) x else -x
abs(-2)


def sqrt(x: Double) = {
  def sqrtInter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtInter(improve(guess))

  def isGoodEnough(guess: Double) =
    (abs(guess * guess - x)/x) < 0.00001
  def improve(guess: Double) = (guess + x / guess) / 2

  sqrtInter(1.0)
}

sqrt(4)

val x = 0

def f(y: Int) = y +1

val result = {
  val x = f(3);
  x * x
} + x
