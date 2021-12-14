package ru.kontur.test.benchmark

import org.openjdk.jmh.annotations.*
import ru.kontur.kinfra.kfixture.model.CollectionSettings
import ru.kontur.kinfra.kfixture.processor.impl.FixtureProcessor
import ru.kontur.kinfra.kfixture.processor.scanner.CachedAnnotationScanner
import ru.kontur.kinfra.kfixture.processor.scanner.GeneratorAnnotationScannerImpl
import ru.kontur.kinfra.kfixture.utils.toKType

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Measurement(iterations = 5, batchSize = 1)
@State(value = Scope.Benchmark)
open class KFixtureBenchmarkWithCache {
    private lateinit var fixtureProcessor: FixtureProcessor

    @Setup
    fun setup() {
        fixtureProcessor = FixtureProcessor(CollectionSettings(), CachedAnnotationScanner(GeneratorAnnotationScannerImpl(
            listOf())))
    }

    @Benchmark
    fun shouldGenerate() {
        fixtureProcessor.generateParam(User::class, User::class.java.toKType(), null)
    }
}