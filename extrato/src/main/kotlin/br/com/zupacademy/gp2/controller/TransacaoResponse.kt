package br.com.zupacademy.gp2.controller

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime

@Introspected
data class TransacaoResponse(
    val operacao: String?,
    val valor: BigDecimal?,
    val data: LocalDateTime?,
) {

}