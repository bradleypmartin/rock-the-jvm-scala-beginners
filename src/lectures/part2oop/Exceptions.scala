package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length) <- this will crash with NPE

  // 1) throwing exceptions
  // throw new NullPointerException <- actively throwing NPE

  // throwable classes extend the Throwable class
  // Exception and Error are the major throwable subtypes
  // (both will crash your JVM)

  // 2) How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  try {
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught an RTE!")
  } finally {
    // code that will get executed no matter what
    // (optional) and does NOT influence the return (only for side effects)
    println("finally")
  }

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  throw exception
}
