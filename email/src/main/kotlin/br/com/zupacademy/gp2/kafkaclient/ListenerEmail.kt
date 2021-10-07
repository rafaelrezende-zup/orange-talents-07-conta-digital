package br.com.zupacademy.gp2.kafkaclient

import br.com.zupacademy.gp2.model.Email
import br.com.zupacademy.gp2.repository.EmailRepository
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import jakarta.inject.Inject

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class ListenerEmail(@Inject val repository: EmailRepository) {

    @Topic("\${kafka.topics.email}")
    fun registra(email: String) {
        repository.save(Email(email))
    }

}