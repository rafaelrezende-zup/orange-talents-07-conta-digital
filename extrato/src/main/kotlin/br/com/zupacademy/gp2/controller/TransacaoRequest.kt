package br.com.zupacademy.gp2.controller

import br.com.zupacademy.gp2.model.Extrato
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Introspected
data class TransacaoRequest(
    @field: NotBlank
    val operacao: String?,
    @field: Positive
    val valor: BigDecimal?,
    @field: FutureOrPresent
    val data: LocalDateTime?,
    @field: NotBlank
    val cliente: String?,
    @field: NotBlank
    val conta: String?
) {
    fun toModel() : Extrato{
        return Extrato(
            operacao,
            valor,
            data,
            cliente,
            conta
        )
    }

}
