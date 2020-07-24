package exercises.part2oop

object OOExercises extends App {
  // Ex1: create Writer and Novel class
  val writer1 = new Writer("Stephen", "King", 1960)
  println(s"writer1's full name: ${writer1.fullName()}")

  val novel1 = new Novel("Scary Book", 1987, writer1)
  val novel2 = novel1.copy(2019)
  println(s"New edition published: ${novel2.yearOfRelease}")

  /*
    Ex2: counter class
      - receives an int value
      - method current count
      - method to increment/decrement
      - overload inc/dec to receive an amount
  */
  val myCount = new Counter(0)
  myCount.increment()
  myCount.increment(7)
  myCount.decrement()
  myCount.decrement(4)
  println(s"After several ops, my count is: ${myCount.count}")

}

class Writer(val firstName: String, val surname: String, val year: Int) {
  def fullName(): String = {
    firstName + " " + surname
  }
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  val authorAge: Int = 2020 - author.year

  def copy(newYearOfRelease: Int): Novel = {
    new Novel(name, newYearOfRelease, author)
  }

  // Note: Daniel does a little fancy stuff with a isWrittenBy(author) method
}

class Counter(var count: Int) {
  def currentCount(): Int = this.count
  // you can also use immutability here with this instead:
  // def inc = new Counter(count + 1)
  // def dec = new Counter(count -1)
  // ...etc. with the overloads
  // we're going to use immutability a lot!

  def increment() = {
    count += 1
  }

  def increment(amount: Int): Unit = {
    count += amount
  }

  def decrement() = {
    count -= 1
  }

  def decrement(amount: Int): Unit = {
    count -= amount
  }

}
