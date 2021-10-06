package br.com.zupacademy.gp2.kafkaclient

import br.com.zupacademy.gp2.controller.TransacaoRequest
import br.com.zupacademy.gp2.repository.ExtratoRepository
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import jakarta.inject.Inject

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class ListenerTransacao(@Inject val repository: ExtratoRepository) {

    @Topic("\${kafka.topics.transacao}")
    fun registra(request: TransacaoRequest) {
        repository.save(request.toModel())
    }

}