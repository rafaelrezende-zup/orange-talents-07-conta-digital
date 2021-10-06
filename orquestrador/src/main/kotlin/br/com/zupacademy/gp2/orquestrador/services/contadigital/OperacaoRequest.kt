package br.com.zupacademy.gp2.orquestrador.services.contadigital

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
data class OperacaoRequest(
        @Positive
        @NotNull
        val valor: BigDecimal
)