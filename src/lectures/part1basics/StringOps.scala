package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // returns char at zero-idx
  println(str.charAt(2))

  // other ops
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length())

  // these string operations are all from Java

  val aNumberString = "2"
  val aNumber = aNumberString.toInt

  // prepending/appending
  println('a' +: aNumberString :+ 'z')

  println(str.reverse)
  println(str.take(2)) // prefix of 2 chars

  // Scala-specific: String interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old."
  println(greeting)

  // Can also include more complex expressions in interpolation
  val newGreeting = s"I will be turning ${age + 1} soon."
  println(newGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute."
  println(myth)

  // Interpolators can also do a bit of type checking/safety.

  // raw-interpolator (doesn't respect escape chars)
  println(raw"This is a \n newline")

  // BUT if we raw-interpolate with a string that ALREADY has an escape,
  // it'll be respected.
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
