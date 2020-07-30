package lectures.part4patternMatching

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // wildcard
  }

  println(x)
  println(description)

  // match is like a switch in other languages, but much more powerful

  // 1 Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "I don't know who I am."
  }

  println(greeting)

  // This is pretty great and non-trivial! ^
  // can also put guards (predicate/filters) on match cases

  /*
  Notes:
  * Cases are matched in order
  * If no cases match will throw a scala.MatchError
  * ...so make sure to cover up with wildcards
  * type of match return is union of all the returns (here String, but can be Any easily)
  * PM works really well for case classes (need to do more work with non-case classes)
   */

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    // extractor pattern for case class Dog
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed.")
  }
  println(animal)

  // match everything (common pattern with the strength of PM in scala)
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }
  // WHY?!
  val isEvenNormal = x % 2 == 0
}
