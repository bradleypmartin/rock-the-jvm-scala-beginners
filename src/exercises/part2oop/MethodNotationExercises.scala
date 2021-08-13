package exercises.part2oop

import scala.language.postfixOps

object MethodNotationExercises extends App {
  // 1 overload + operator that receives String and returns another person
  //   with nickname (overload infix operator)

  // 2 Add age to the Person class
  //   Add a unary + operator => new person with age + 1

  // 3 Add a 'learns' method in the Person class => "Mary learns Scala"
  //   Add a 'learnsScala' method, calls learns method with "Scala"
  //   Use in postfix notation

  // 4 Overload the apply method
  //   mary.apply(2) => "Mary watched Inception 2 times."

  class Person(val name: String, val age: Int) {
    def +(nickname: String): Person = {
      new Person(this.name + " " + nickname, this.age)
    }

    def unary_+ : Person = {
      new Person(this.name, this.age + 1)
    }

    def learns(skill: String): String = {
      this.name + " learns " + skill
    }

    def learnsScala: String = {
      this.learns("Scala")
    }

    def apply(ageAsk: Int): String = {
      this.name + " was asked about his/her age " + ageAsk + " times."
    }
  }

  // 1 Impl
  val mary = new Person("Mary", 25)
  val nickMary = mary + "the Great"
  println(nickMary.name)

  // 2 Impl
  val maryOlder = +mary
  println(maryOlder.age)

  // 3 Impl
  println(mary learnsScala)

  // 4 Impl
  println(mary(3))
}
