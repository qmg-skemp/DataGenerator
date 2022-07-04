package com.example.DataGenerator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication class CsvGeneratorApplication

fun main(args: Array<String>) {
    runApplication<CsvGeneratorApplication>(*args)
}
