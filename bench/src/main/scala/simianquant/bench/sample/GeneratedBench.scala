package simianquant.bench.sample

import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Mode, OutputTimeUnit}
import org.openjdk.jmh.infra.Blackhole
import simianquant.ext.GeneratedImpl

@BenchmarkMode(Array(Mode.SampleTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class GeneratedBench {

  @Benchmark
  def oneDimensionalEvaluation(bh: Blackhole): Unit = {
    var x = 1.4
    var yMin = 1.0
    var yMax = 2.0
    var cnt = 1000
    var incr = (yMax - yMin) / cnt

    var y = yMin
    while (y < yMax) {
      val eval = GeneratedImpl(x, y)
      bh.consume(eval)
      y += incr
    }
  }

}
