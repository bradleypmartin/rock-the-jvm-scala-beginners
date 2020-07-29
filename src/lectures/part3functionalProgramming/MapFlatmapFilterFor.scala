package lectures.part3functionalProgramming

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  // mapping
  println(list.map(_ + 1))

  // filter
  println(list.filter(_ % 2 == 1))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between the two lists (alternative to
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c')
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  // foreach
  list.foreach(println)

  val colors = List("black", "white")

  // scala shorthand for all these chains: for-comprehensions
  // these are kind of preferred in practice
  val forCombinations = for {
    n <- numbers if n % 2 == 1 // comprehension with guard (filter)
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  
}
