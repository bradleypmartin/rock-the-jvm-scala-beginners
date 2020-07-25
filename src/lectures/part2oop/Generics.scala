package lectures.part2oop

object Generics extends App {

  // generic type A
  class MyList[A] {
    // use the type A
  }

  // can have multiple type parameters too
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // yes List[Cat] extends List[Animal] = 'covariance'
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? hard question (non-trivial)

  // no (invariance)
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // definitely not (contravariance)
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types (subtype operator - upper bounded type)
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // val newCage = newCage(new Car) // not possible (Car isn't an Animal child)

  // if we have a covariant list of Cats, then add a Dog
  // it'll turn into a list of Animals

  // Takeaways
  // * Use the same code on many (potentially unrelated) types
  // * Can also have generic methods
}
