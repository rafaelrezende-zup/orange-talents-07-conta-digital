package br.com.zupacademy.gp2.orquestrador.services.kafka

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.MessageBody

@KafkaClient
interface TransacaoClient {

    @Topic("\$services.kafka.topic.trasacao")
    fun sendTrasacao(@MessageBody operacaoProducer: TransacaoProducer)
}