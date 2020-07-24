package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // name is very important here - even space before colon (prefix)
    def unary_! : String = s"$name, what the heck?!"

    // postfix (no params)
    def isAlive: Boolean = true

    // apply
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // here's another way to call the 'likes' method
  println(mary likes "Inception") // equivalent; 'infix'/operator notation

  // (example of syntactic sugar)

  // 'operators' in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangoutWith tom)
  println(mary + tom)

  // Note above how permissive we are with method names
  // Also, all operators are methods! e.g.:
  println(1.+(2))

  // For example, Akka actors have ! ? -type methods

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-

  // unary_ prefix only works with -, +, ~, !
  println(!mary)

  // postfix notation
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // does the same thing! Looks for definition of 'apply()'
}
