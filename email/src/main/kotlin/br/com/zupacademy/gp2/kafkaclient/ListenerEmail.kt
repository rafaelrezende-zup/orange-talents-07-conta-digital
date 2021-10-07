package br.com.zupacademy.gp2.kafkaclient

import br.com.zupacademy.gp2.model.Email
import br.com.zupacademy.gp2.repository.EmailRepository
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import jakarta.inject.Inject
import org.slf4j.LoggerFactory

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class ListenerEmail(@Inject val repository: EmailRepository) {
    val logger = LoggerFactory.getLogger(this :: class.java)

    @Topic("\${kafka.topics.email}")
    fun registra(email: String) {
        logger.info("Enviando email: $email")
        repository.save(Email(email))
    }

}