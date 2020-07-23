package lectures.part1basics

object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  // like calling on a static long
  calledByValue(System.nanoTime())

  // like calling by reference (changes over time)
  // basically, nanoTime() replaces 'x' in the function above
  calledByName(System.nanoTime())

  // Takeaway: 'rocket' calls by name/ref

  // example: lazy loading
  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = {
    println(x)
  }

  // will fail (infinite loop)
  // printFirst(infinite(), 34)

  // works! (lazy load)
  printFirst(34, infinite())
}
