package lectures.part3functionalProgramming

object TuplesAndMaps extends App {
  // tuples = finite ordered 'lists'
  val aTuple = new Tuple2(2, "hello Scala") // Tuple2[Int, String] = (Int, String)

  // Tuples can be created with or without the keyword 'new'
  // another quick way to define:
  val aTuple2 = (2, "hello Scala")

  // accessing:
  println(aTuple._1) // gives 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  // tuples can be used in map defs
  val phonebook = Map(("Jim", 555), ("Daniel", 789), "Julie" -> 254)

  // ^ a -> b is sugar for (a, b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))

  // note that map apply() with a key doesn't exist will throw an exception
  // UNLESS you create .withDefaultValue(-1) e.g.

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phonebook + newPairing // maps are immutable
  println(newPhoneBook)

  // functionals on map
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys (this is actually deprecated now)
  // println(phonebook.filterKeys(x => x.startsWith("J")))

  // mapValues (also deprecated)
  // println(phonebook.mapValues(number => "0245-" + number))

  // conversions to/from other collections
  println(phonebook.toList) // list of tuples
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "Britney", "Jenny")
  println(names.groupBy(name => name.charAt(0)))
}
