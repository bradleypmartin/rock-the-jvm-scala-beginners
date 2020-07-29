package lectures.part3functionalProgramming

object AnonymousFunctions extends App {

  // takeaways
  /*
  Instead of passing anonymous FunctionX instances every time,
  we can use Lambdas:

  (x, y) => x + y
  e.g. (name: String, age: Int) => name + " is " + age + " years old"

  further sugar:
  val add: (Int, Int) => Int = _ + _
   */

  // object-oriented way to define
  val doubler = new Function1[Int, Int] {
    override def apply(x: Int) = x * 2
  }

  // anonymous function (Lambda)
  // below: value of function1
  val doubler2 = (x: Int) => x * 2

  // multiple params in a lambda
  val adder = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething = () => 3

  // address (function itself)
  println(justDoSomething)
  // actual call of the function (prints '3')
  println(justDoSomething())

  // curly braces with lambdas (style sometimes used)
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // more syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // one param shorthand
  val niceAdder: (Int, Int) => Int = _ + _ // two param equivalent

  // Ex 2: writing curried function as anonymous
  val curriedAdder = (a: Int) => (b: Int) => a + b
  println(curriedAdder(4)(7))

}
