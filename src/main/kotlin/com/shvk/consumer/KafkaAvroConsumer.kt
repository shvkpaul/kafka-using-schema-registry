package com.shvk.consumer

import com.shvk.dto.Employee
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class KafkaAvroConsumer {
    @KafkaListener(topics = ["\${topic.name}"])
    fun read(consumerRecord: ConsumerRecord<String, Employee>) {
        val key = consumerRecord.key()
        val employee = consumerRecord.value()
        println("Avro message received for key : $key value : $employee")
    }
}