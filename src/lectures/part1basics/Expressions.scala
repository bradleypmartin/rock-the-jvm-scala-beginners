package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)

  // lots of operators available including:
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  // comparators too
  println(1 == x)

  // other incremental operators are available
  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // kinda like a ternary expr

  // There ARE loops in Scala but we usually discourage using them
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // TRY NOT TO WRITE THIS AGAIN (writing imperative code with Scala)
  // We should try to write everything as an expression

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue) // shows "()"

  // side effects: println(), whiles, reassigning (return Unit)

  // Code blocks (these are expressions, and value of block is val of last expr)
  // As in other langs, variables interior to the code block are scoped to the block

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // Remember from today:
  // * instructions are EXECUTED (think Java)
  // * expressions are EVALUATED (think Scala)

  // EXERCISES

  // 1. difference between "hello world" vs println("hello world")
  // my ans: the former is a String; the latter is a...Unit, I think?
  // instructor: the latter is a 'side effect' with return of Unit

  // 2. value of the following:
  val someValue = {
    2 < 3
  }
  // my ans: should be Boolean true

  // 3. value of the following:
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // my ans: is it 42 because that's the final (simple) expression?
}

