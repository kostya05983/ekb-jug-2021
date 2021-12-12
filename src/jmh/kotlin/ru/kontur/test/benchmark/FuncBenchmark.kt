package ru.kontur.test.benchmark

import org.openjdk.jmh.annotations.*
import java.util.*

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Measurement(iterations = 5, batchSize = 1)
@State(value = Scope.Benchmark)
open class FuncBenchmark {

    @Benchmark
    fun `should generate`() {
        User(
            id = UUID.randomUUID(),
            type = UserType.TYPE_1,
            notificationId = UUID.randomUUID(),
            onceMoreId = UUID.randomUUID()
        )
    }
}