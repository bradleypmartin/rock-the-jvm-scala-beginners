package lectures.part2oop

object Objects extends App {
  // Scala does NOT have class-level functionality (no 'static')
  // BUT objects can have 'static-like' functionality

  object Person {
    // static/class-level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  // you can also 'overload' the type Person
  class Person (val name: String) {
    // instance-level functionality
  }
  // These pairs of objects and classes are called 'companions'

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = singleton instance
  // (type + its ONLY instance - no params (vs. classes))
  val mary = Person
  val john = Person

  // This yields true
  println(mary == john)

  // But what if we say...
  val maryc = new Person("Mary")
  val johnc = new Person("John")

  // not true anymore; these are different instances of the Person CLASS
  println(maryc == johnc)

  // using factory method to make Bobby
  val bobby = Person(maryc, johnc)
  println(bobby.name)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

  // so another way to get our code to run (besides extends App)
  // is the signature above wrapping our code
}
