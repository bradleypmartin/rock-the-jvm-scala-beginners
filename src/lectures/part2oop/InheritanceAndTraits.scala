package lectures.part2oop

object InheritanceAndTraits extends App {

  // Scala has single-class inheritance like other langs.
  class Animal {
    def eat = println("nomnom")

    // note: these can be private and protected
    //       private: only accessible in THIS class
    //       protected: only accessible in this and CHILD classes (not 'in code')
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat

  // constructors
  class Person(name: String, age: Int) {
    // can use aux constructor too if you want in extends statement
    def this(name: String) = this(name, 0)
  }

  // need to call Person constructor first
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding (can work for methods OR val/var
  class Dog extends Animal {
    override def eat: Unit = println("crunch, crunch")
  }

  val dog = new Dog
  dog.eat

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat

  // can call superclass methods with super.method too

  // preventing overrides
  // 1 - use keyword final
  // 2 - use final on class itself
  // 3 - seal the class (extend classes in THIS FILE but prevent in other files)
}
