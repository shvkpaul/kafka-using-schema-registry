package com.shvk.producer

import com.shvk.dto.Employee
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.concurrent.CompletableFuture

@Service
class KafkaAvroProducer(
    @Value("\${topic.name}") private val topicName: String,
    private val template: KafkaTemplate<String, Employee>
) {
    fun send(employee: Employee) {
        val future: CompletableFuture<SendResult<String, Employee>> =
            template.send(topicName, UUID.randomUUID().toString(), employee)
        future.whenComplete { result: SendResult<String, Employee>, ex: Throwable? ->
            if (ex == null) {
                println(
                    "Sent message=[" + employee + "] with offset=[" + result.recordMetadata.offset() + "]"
                )
            } else {
                println(
                    "Unable to send message=[" + employee + "] due to : " + ex.message
                )
            }
        }
    }
}