package com.shvk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaUsingSchemaRegistryApplication

fun main(args: Array<String>) {
	runApplication<KafkaUsingSchemaRegistryApplication>(*args)
}
