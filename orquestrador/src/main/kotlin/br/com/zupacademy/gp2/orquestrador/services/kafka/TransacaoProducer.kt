package br.com.zupacademy.gp2.orquestrador.services.kafka

import java.math.BigDecimal
import java.time.LocalDateTime

class TransacaoProducer(
        val operacao: Operacoes,
        val valor: BigDecimal,
        val data: LocalDateTime,
        val clienteId: String,
        val conta: String
)