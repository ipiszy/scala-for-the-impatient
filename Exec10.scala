import java.io.{FileInputStream, InputStream}

// 9
trait Logger {
  def log(msg: String)
}

trait ConsoleLogger extends Logger with Cloneable with Serializable {
  override def log(msg: String): Unit = print(msg)
}

trait TimestampLogger extends Logger {
  abstract override def log(msg: String) = super.log(new java.util.Date().toString + " " + msg)
}

trait BufferedLogger extends Logger {
  private val bufferSize = 10
  private val buffer = new Array[Char](bufferSize)
  private var bufferOffset = 0

  abstract override def log(msg: String) = {
    var idx = 0
    while (idx < msg.length) {
      val nextToWrite = (bufferSize - bufferOffset).min(msg.length - idx)
      msg.getChars(idx, idx + nextToWrite, buffer, bufferOffset)
      idx += nextToWrite
      bufferOffset += nextToWrite
      if (bufferOffset == bufferSize) {
        super.log(buffer.mkString)
        bufferOffset = 0
      }
    }
  }
}

trait NewLineLogger extends Logger {
  abstract override def log(msg: String) = super.log(msg + "\n")
}

class IpiszyLogger extends ConsoleLogger with BufferedLogger with TimestampLogger with NewLineLogger {}


// 1
trait RectangleLike {
  def setFrame(x: Double, y: Double, w: Double, h: Double): Unit
  def getX: Double
  def getY: Double
  def getWidth: Double
  def getHeight: Double

  def translate(dx: Int, dy: Int): Unit = {
    setFrame(getX + dx, getY + dy, getWidth, getHeight)
  }
  def grow(horizontal: Int, vertical: Int): Unit = {
    setFrame(getX - horizontal / 2, getY - vertical / 2,
      getWidth + horizontal, getHeight + vertical)
  }
}

// 2
class OrderedPoint extends java.awt.Point with scala.math.Ordered[Point] {
  override def compare(that: Point): Int = {
    if (this.x == that.x) this.y - that.y
    else this.x - that.x
  }
}

// 3
// collection.mutable.BitSet =>
// Serializable >> SetLike >> BitSetLike >> scala.collection.BitSet >> SortedSet

// 8
trait BufferedInputStream extends java.io.InputStream {
  private val bufferSize = 1024
  private val buffer = new Array[Byte](bufferSize)
  private var bufferOffset = 0
  private var bufferEndOffset = 0

  private def readToBufferIfNecessary() = {
    if (bufferOffset == bufferEndOffset) {
      bufferEndOffset = super.read(buffer)
      bufferOffset = 0
    }
  }

  override def read(): Int = {
    readToBufferIfNecessary()
    if (bufferEndOffset == -1) -1
    else {bufferOffset += 1; buffer(bufferOffset - 1).toInt}
  }
}

// 10
trait IterableInputStream extends InputStream with Iterable[Byte] {outer =>

  class Iterator extends collection.Iterator[Byte] {
    var byte: Byte = 0
    var hasNextByte = false

    override def hasNext: Boolean = {
      val nextInt = outer.read()
      if (nextInt == -1) {
        hasNextByte = false
      } else {
        hasNextByte = true
        byte = nextInt.toByte
      }
      nextInt != -1
    }

    override def next(): Byte = {
      if (hasNextByte) {
        hasNextByte = false
        byte
      } else {
        outer.read().toByte
      }
    }
  }

  abstract override def read(): Int = super.read()
  override def iterator: collection.Iterator[Byte] = new Iterator()
}

class IpiszyIterableFileInputStream(fileName: String)
  extends FileInputStream(fileName) with IterableInputStream {}

object Exec10 extends App {
  val logger = new IpiszyLogger
  logger.log("ipiszy is super!")

  // 1
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  egg.translate(10, -10)
  egg.grow(10, 20)
  println(egg.getX, egg.getY, egg.getWidth, egg.getHeight)

  // 8
  val ipiszyInput = new FileInputStream("/Users/carolzhang/ipiszy") with BufferedInputStream
  var char = ipiszyInput.read()
  while (char != -1 && char != '\n'.toInt) {
    print(char.toChar)
    char = ipiszyInput.read()
  }
  println

  // 9
  val ipiszyLogger = new IpiszyLogger()
  ipiszyLogger.log("ipiszy")
  ipiszyLogger.log("lalala, lalala, I'm a super girl! Blackkkkkkkkkk Fridayyyyyyyyyyy!")

  // 10
  val ipiszyIS = new IpiszyIterableFileInputStream("/Users/carolzhang/ipiszy")
  for (byte <- ipiszyIS) print(byte.toChar)
}
