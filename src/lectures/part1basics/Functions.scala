package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  // can also call like:
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.
  // 'worst thing Scala user can do is implement imperative code with Scala syntax'

  // NOTE: you can get away with a NON-recursive function not
  //       having a return type, but not with a recursive function.
  // BEST PRACTICE: always declare return types.

  def aFunctWithSideEffects(aString: String): Unit = println(aString)

  // Code blocks also allow you to define functions inside
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  // Ex 1: Greeting function (name, age) => "Hi, my name is $name and I am $age."
  def greetFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + "."
  }
  println(greetFunction("Addy", 7))

  // Ex 2: Factorial function
  def factFunction(n: Int): Int = {
    if (n == 1) 1 else n * factFunction(n-1)
  }
  println(factFunction(5))

  // Ex 3: Fib function
  // 1 1 2 3 5 8 13
  def fibFunction(n: Int): Int = {
    if (n == 0) 1
    else if (n == 1) 1
    else fibFunction(n-1) + fibFunction(n-2)
  }
  println(fibFunction(6))

  // Ex 4: Test if a number is prime
  def isPrime(n: Int, div: Int): Boolean = {
    if (n == 1) false
    else if (n == div) true
    else if (n % div == 0) false
    else if (div * div >= n) true
    else isPrime(n, div + 1)
  }
  println("Is 7 prime? " + isPrime(7, 2))
  println("Is 9 prime? " + isPrime(9, 2))
  println("Is 13 prime? " + isPrime(13, 2))

  // Ex 4 instructor solution
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n / 2)
  }
}
