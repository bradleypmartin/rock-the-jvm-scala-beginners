package lectures.part4patternMatching

object AllThePatterns {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard

  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchVariable = x match {
    case something => s"I've found $something"
  }

  // 3 tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2,3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }

  // PMs can be nested!

  // 4 - case classes - constructor pattern

  // 5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1,2,3) :+ 42 => // infix pattern
  }

  // 6 - type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 - name binding

  // 8 - multi-patterns
  
}
