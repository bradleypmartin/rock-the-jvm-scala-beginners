package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  println(person.newProperty)

  person.greet("Daniel")
  person.greet()
}

class Person(name: String, val age: Int) { // constructor
  // body (val/var defs in here ARE fields)
  val newProperty = "new prop"

  // within this method, pay close attention to the difference between
  // method param (entered in method invocation) and class param
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // note we can overload functions (different signatures = different params)
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple/overloaded constructors
  // the ONLY implementation an aux constructor can have is ANOTHER constructor
  def this(name: String) = this(name, 0) // usually will do this with default params
}

// note that class PARAMS are NOT fields (can't access with dot notation)
// need to put val/var in front if you want that behavior