package br.com.zupacademy.gp2.contadigital.dto

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.Positive

@Introspected
data class OperacaoRequest (
    @field:Positive
    val valor: BigDecimal
        ){

}
