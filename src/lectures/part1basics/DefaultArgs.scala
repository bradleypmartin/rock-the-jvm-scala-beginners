package lectures.part1basics

object DefaultArgs extends App {

  @scala.annotation.tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n * acc)

  // Some functions will always (95%+ of the time) be called with the same
  // parameter values. One way around this is to make helper/aux functions
  // like we did before. OR we can use default values as above.

  println(trFact(10))

  // We have to be careful, though, that we can only:
  // 1) Pass in every LEADING argument
  // 2) Name the arguments

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = {
    println("saving picture")
  }

  // Added benefit: if you name your params, you can pass args in different orders.
}
