package br.com.zupacademy.gp2.orquestrador.controller

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
data class TransacaoRequest(
        @field:NotNull
        @field:Positive
        val valor: BigDecimal,

        @field:NotBlank
        val clienteId: String
)