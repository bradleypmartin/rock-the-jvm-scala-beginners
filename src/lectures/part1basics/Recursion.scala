package lectures.part1basics

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - we first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))

  // Each recursive call of the function above uses a 'call stack'
  // If you try and run factorial(5000), you'll get a StackOverflow
  // (stack gets too deep!)

  // another definition
  def anotherFactorial(n: Int): Int = {
    @scala.annotation.tailrec // optional annotation to ensure we've got tail recursion
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  // This way of writing the factorial function works with a big number
  println(anotherFactorial(5000))

  // Note that we'll Int overflow unless we use BigInt

  // Why does this work?
  // If you have a recursive call at the end of a call path, we can have
  // each call REPLACE the last (rather than fill up a stack).

  // When you need loops, use tail recursion!

  // NOTE: going to need as many accumulators as we have recursive calls.

  // Ex 1: Concatenating a string n times, tail recursively
  def concatTail(s: String, n: Int): String = {
    @scala.annotation.tailrec
    def concatHelper(s: String, n: Int, accumulator: String): String =
      if (n < 1) accumulator
      else concatHelper(s, n - 1, accumulator + s)

    concatHelper(s, n, "")
  }

  println("Concatenated s: " + concatTail("s", 10))

  // Ex 2: Tail-recursive IsPrime function
  def isPrimeTail(n: Int): Boolean = {
    @scala.annotation.tailrec
    def primeHelper(n: Int, accCheck: Int): Boolean =
      if (n == 1) false
      else if (accCheck == 1) true
      else (n % accCheck != 0) && primeHelper(n, accCheck - 1)

    primeHelper(n, n / 2)
  }

  println("Is 7 prime? " + isPrimeTail(7))
  println("Is 9 prime? " + isPrimeTail(9))
  println("Is 13 prime? " + isPrimeTail(13))

  // Ex 3: Tail-recursive Fib function
  def fibTail(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, lastm1: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + lastm1, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibTail(8))
}
