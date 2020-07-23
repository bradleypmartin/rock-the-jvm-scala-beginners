package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  // 1) can't reassign val e.g. x = 2 (immutable)
  // 2) types of vals are optional (can be implicit)
  val x2 = 21

  val aString: String = "hello"

  // 3) semicolons are ALLOWED, but only really needed if we write
  //    more than one expr on a line (not recommended)

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 5278L
  val aFloat: Float = 2.0f // need that 'f' at the end or it'll assume double
  val aDouble: Double = 3.14

  // variables are mutable
  var aVariable: Int = 4

  aVariable = 5
}
