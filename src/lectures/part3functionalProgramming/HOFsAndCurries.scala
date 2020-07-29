package lectures.part3functionalProgramming

object HOFsAndCurries extends App {
  // reading higher-order functions can be kind of difficult
  // a function that has a function as a parameter is a Higher-Order Function (HOF)

  // function that applies a function n times over a given value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x)))
  @scala.annotation.tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // another way to implement the nTimes function -> return a function to use later!
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x)) // curried recursion

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // recall curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameter lists (act like curried functions)
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  // exercise: compose(f,g) => x => f(g(x))
  def composer(f: Int => Int, g: Int => Int): (Int => Int) =
    (x: Int) => f(g(x))

  val add7 = (x: Int) => x + 7
  val mult3 = (y: Int) => y * 3
  val composed = composer(mult3, add7)
  println(composed(5))
}
