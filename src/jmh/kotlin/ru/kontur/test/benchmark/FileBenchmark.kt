package ru.kontur.test.benchmark

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.openjdk.jmh.annotations.*
import java.io.FileReader

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Measurement(iterations = 5, batchSize = 1)
@State(value = Scope.Benchmark)
open class FileBenchmark {

    val objectMapper = ObjectMapper().apply {
        registerKotlinModule()
    }

    @Benchmark
    fun shouldReadFromFile() {
        val file = FileReader("/home/kostya05983/Projects/github/ekb-jug-2021/src/jmh/resources/user.json").readText()
        val json = objectMapper.readValue<User>(file)
    }
}