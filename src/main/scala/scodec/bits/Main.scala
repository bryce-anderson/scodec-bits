package scodec.bits

/**
 * Created by brycea on 4/20/14.
 */
object Main {

  def mkVec(depth: Int, length: Int): ByteVector = {
    val vecs = for (i <- 0 until depth) yield ByteVector(0 until length map {_.toByte})
    vecs.reduce(_ ++ _)
  }

  def bench() = {
    val repeats = 10000000
    var acc = 0
    val vec = mkVec(10, 100)

    val start = System.currentTimeMillis()
    for (i <- 0 until repeats) {
      acc += vec.toArray(1)

    }
    System.currentTimeMillis()-start
  }

  def main(args: Array[String]) {
    println("Warming up.")
    bench()
    println("Running.")
    println(s"Time: ${bench}")


  }

}
