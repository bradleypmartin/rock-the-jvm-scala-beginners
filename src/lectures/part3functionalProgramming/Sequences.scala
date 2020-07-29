package lectures.part3functionalProgramming

import scala.util.Random

object Sequences extends App {

  // Seq
  // very general interface for data structures that:
  //   -- have well-defined order
  //   -- can be indexed
  // supports various operations
  //   -- apply, iterator, length, reverse
  //   -- concatenation, appending, prepending
  //   -- a lot of others (grouping, sorting, zipping, searching, slicing)

  // this actually makes a List automatically
  val aSequence = Seq(1,2,3,4)
  println(aSequence)

  println(aSequence.reverse)

  // apply with (2) gives 3rd element
  println(aSequence(2))

  // concatenation
  println(aSequence ++ Seq(5,6,7))

  // sorting
  val unorderedSeq = Seq(7,5,3)
  println(unorderedSeq.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  // Shorter range syntax
  (1 to 5).foreach(x => println("Hello"))

  // Lists are immutable
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  println(prepended)
  println( 0 +: aList :+ 4)

  // filling
  val apples5 = List.fill(5)("apple") // note the curried function!
  println(apples5)

  // array
  // -- equiv of simple Java arrays
  // -- can be mutated
  // -- indexing is fast
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println)

  // mutation (with sytactic sugar on numbers.update(2, 0)
  numbers(2) = 0
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers

  // wrapped array or implicit conversion ^
  println(numbersSeq)

  // vector
  // -- default implementation for immutable sequences
  // -- effectively constant indexed read/w
  // -- fast element addition append/prepend
  // -- implemented as fixed-branch trie (branch factor 32)
  // -- good performance for large sizes

  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vector vs list perf test

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), 0)
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps ref to tail
  // updating element in the middle takes a long time
  println(getWriteTime(numbersList))

  // depth of tree is small
  // needs to replace entire 32-element chunk
  println(getWriteTime(numbersVector))

}
