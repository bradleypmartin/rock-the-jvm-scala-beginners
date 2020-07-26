package lectures.part2oop

import exercises.part2oop.Writer
import playground.{Prince, Princess}
// can also do
// import playground._
// OR can alias like...
// import playground.{Princess => DisneyPrincess}

object PackagingAndImports extends App {

  // package members are accessible by simple name
  // BUT need to import packages otherwise (this one's from exercises)
  val writer = new Writer("Stephen", "King", 1960)

  // another way you can do this _without_ importing is with a FQN
  // e.g. val x = new playground.Princess
  val cinderella = new Princess

  // packages are in hierarchy matching folder structure

  // Scala-specific: package object (outside of classes/traits)
  // NOTE: can only have ONE per package (name: package.scala)
  // Can define universal methods/constants here
  // can reference with simple names
  // kind of rare to see in the wild, but great when you need them
  sayHello
  println(SPEED_OF_LIGHT)

  // imports, cont'd (note how objects in same package get grouped)
  val prince = new Prince

  // default imports: done without any intention on our side
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
