package lectures.part3functionalProgramming

object WhatsAFunction extends App {

  // takeaways
  /*
  * want to work with functions
    * pass funcs as parameters
    * use functions as values
  * problem: Scala works on top of the JVM
    * designed for Java
    * first-class elements: OBJECTS (instances of classes)
  * solution: all scala functions are objects!
    * function traits, up to 22 params
    * syntactic sugar function types
    * e.g. Function2[Int, String, Int] === (Int, String) => Int
   */

  // the DREAM: use functions are first class elements
  // PROBLEM: we come from OOP (everything is classes!)
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types: Function1[A, B]
  // supported by default up to 22 parameters
  val stringToIntCoverter = new ((String) => Int) {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntCoverter("3") + 4)

  val adder = new ((Int, Int) => Int) {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL Scala functions are objects! (since we derive from Java)

  // Ex 1: String concatenation
  val stringConcat = new ((String, String) => String) {
    override def apply(a: String, b: String): String = a + b
  }

  println(stringConcat("a", "b"))

  // Ex 3: Function return type
  // Function1[Int, Function1[Int, Int]]
  val superAdder: (Int) => ((Int) => Int) = (x: Int) => (y: Int) => x + y
  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // 'curried function'
}

// in Java, e.g. we'd make classes to represent/contain actions
/*
class Action {
  def execute(element: Int): String = ???
}
 */

// in Scala, we do something more like:
trait MyFunction[A, B] {
  def apply(element: A): B
}