package exercises.part2oop

object MyList extends App {
  /*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is the list empty
  add(int) => new list with this element added
  toString => a string representation of the list
   */

  abstract class absList {
    def head: Int
    def tail: absList
    def isEmpty: Boolean
    def add(element: Int): absList
    def printElements: String
    // Note: this method is available in AnyRef; need to override
    override def toString: String = "[" + printElements + "]"
  }

  object Empty extends absList {
    def head: Int = throw new NoSuchElementException
    def tail: absList = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add(element: Int): absList = new Cons(element, Empty)
    def printElements: String = ""
  }

  class Cons(h: Int, t: absList) extends absList {
    def head: Int = h
    def tail: absList = t
    def isEmpty: Boolean = false
    def add(element: Int): absList = new Cons(element, this)
    def printElements: String = {
      if (t.isEmpty) "" + h
      else h + " " + t.printElements
    }
  }

  val list = new Cons(1, Empty)
  val nextList = list.add(4)
  val finalList = nextList.add(7)
  println(finalList.toString)
}