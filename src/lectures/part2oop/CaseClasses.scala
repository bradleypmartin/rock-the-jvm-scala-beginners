package lectures.part2oop

object CaseClasses extends App {
  // TAKEAWAYS

  /*
  * Quick lightweight DSs with little boilerplate
  * Companions already implemented
  * Sensible equals, hashCode, toString
  * Auto-promoted params to fields
  * Cloning
  * 'Case objects' work in much the same way

   */

  // oftentimes you would have to reimplement stuff like
  // equals, hashCode, toString, etc...Case Classes can help with this.

  case class Person(name: String, age: Int)

  // 1. class params are fields automatically
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString out-of-the-box
  println(jim.toString)

  // 2b. println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented OOTB (great for collections!)
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // (If Person weren't a case class, this equality would return
  //  'false' - different instances)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45) // optional overwrite of fields

  // 5. CCs have companion objects (and applys by default)
  val thePerson = Person
  val mary = Person("Mary", 23) // don't usually use 'new' with CCs

  // 6. CCs are serializable (for messaging in particular, CCs are great)
  // Akka

  // 7. CCs have extractor patterns = CCs can be use in pattern matching!
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
