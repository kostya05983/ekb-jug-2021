package ru.kontur.test.benchmark

import org.openjdk.jmh.annotations.*
import java.util.*

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 5, batchSize = 1)
@State(value = Scope.Benchmark)
open class UUIDGenerateBenchmark {

    @Benchmark
    fun generateUuid() {
        UUID.randomUUID()
    }
}