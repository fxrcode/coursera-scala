
object Basic {

  // https://docs.scala-lang.org/tutorials/scala-for-java-programmers.html
  //  case classes & pattern matching

  // case class differ from standard classes
  // 1. default new/getter/equals/hashCode/toString defined.
  // 2. instances of these classes can be decomposed through pattern matching.
  abstract class Tree
  case class Sum(l: Tree, r: Tree) extends Tree
  case class Var(n: String) extends Tree
  case class Const(v: Int) extends Tree

  // what is environment function for?
  type Environment = String => Int

  // 1st eg of pattern matching: eval
  def eval(t: Tree, env: Environment): Int = t match{
    case Sum(l,r) => eval(l, env) + eval(r, env)
    case Var(n) => env(n)
    case Const(v) => v
  }

  val exp: Tree = Sum(Sum(Var("x"),Var("x")), Sum(Const(7),Var("y")))
  val env: Environment = { case "x" => 5 case "y" => 7 }
  println("Expression: " + exp)
  println("Evaluation with x=5, y=7: " + eval(exp, env))

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  val li = List(7,3,9,2)
  println(isort(li))
}
