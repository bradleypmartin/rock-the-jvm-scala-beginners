package lectures.part3functionalProgramming

object Options extends App {

  /*
  Options are great for:

  * staying away from the NPE boogeyman
  * avoid endless spaghetti with null-related assertions

  It's a functional way of dealing with absences. Tools available:
  * map, flatMap, filter
  * orElse
  * fold, collect, list
   */

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // good for unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(null) // WRONG (Some() should always have value inside)

  // instead do this
  val result = Option(unsafeMethod())
  println(result)

  // in chained methods...this is how you can deal with an unsafe API
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)

  // DESIGN unsafe APIs (it's great to return Options)
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE -> try not to use this

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10)) // returns None (predicate not matched)
  println(myFirstOption.flatMap(x => Option(x * 10)))


}
