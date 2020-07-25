package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // here we're kind of 'cheating' to instantiate kind-of-an-Animal object
  // (Anonymous child class)
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahaha!")
  }

  // this is equivalent to having:
  /*
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahaha!")
  }
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  // 1) Anonymous classes work for NON-abstract classes too
  // 2) BUT you have to respect the correct constructor args
  // 3) If you ARE using this with an abstract class, must implement methods
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?p")
  }
}
