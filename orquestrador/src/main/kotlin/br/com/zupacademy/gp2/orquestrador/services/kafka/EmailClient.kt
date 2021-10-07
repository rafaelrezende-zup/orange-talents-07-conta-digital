package br.com.zupacademy.gp2.orquestrador.services.kafka

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.MessageBody

@KafkaClient
interface EmailClient {

    @Topic("\${services.kafka.topic.email}")
    fun sendEmail(@MessageBody email: String)
}