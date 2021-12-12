package ru.kontur.test.benchmark

import org.openjdk.jmh.annotations.*
import ru.kontur.kinfra.kfixture.utils.FixtureUtils

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Measurement(iterations = 5, batchSize = 1)
@State(value = Scope.Benchmark)
open class KFixtureBenchmark {

    @Benchmark
    fun shouldGenerate() {
        val fixture = FixtureUtils.createClazz<User>()
    }
}