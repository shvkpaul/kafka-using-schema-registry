package com.shvk.controller

import com.shvk.dto.Employee
import com.shvk.producer.KafkaAvroProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class EventController(
    private val producer: KafkaAvroProducer
) {

    @PostMapping("/events")
    fun sendMessage(@RequestBody employee: Employee): String {
        producer.send(employee)
        return "message published !"
    }
}