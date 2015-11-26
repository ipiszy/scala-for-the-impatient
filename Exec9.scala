import java.io.File

object Exec9 extends App {
  val dir = new File("/Users/carolzhang")
  for (d <- dir.listFiles().filter(_.isDirectory()).toIterator) println(d.getName)
}