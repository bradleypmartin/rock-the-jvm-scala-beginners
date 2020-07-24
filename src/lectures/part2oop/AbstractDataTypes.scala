package lectures.part2oop

object AbstractDataTypes extends App {

  // cannot be instantiated
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat(): Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"
    def eat(): Unit = println("nom nom nom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do NOT have constructor parameters
  // 2 - multiple traits may be inherited by the same class (kind of a way to do multiple inheritance)
  // 3 - traits = behavior; class = thing


}
