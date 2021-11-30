package ru.kontur.test.benchmark

import org.openjdk.jmh.annotations.*

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 100, batchSize = 1)
@State(value = Scope.Benchmark)
class RandomEnumBenchmark {

    @Benchmark
    fun generateEnum() {
        UserType.values().random()
    }
}

enum class UserType {
    TYPE1,
    TYPE2,
    TYPE3,
    TYPE4,
    TYPE5,
    TYPE6,
    TYPE7,
    TYPE8,
    TYPE9,
    TYPE10,
    TYPE11,
    TYPE12,
    TYPE13,
}