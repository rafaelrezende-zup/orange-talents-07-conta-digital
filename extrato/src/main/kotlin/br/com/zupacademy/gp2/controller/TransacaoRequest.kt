package br.com.zupacademy.gp2.controller

import br.com.zupacademy.gp2.model.Extrato
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
data class TransacaoRequest(
    @field: NotBlank
    @field: Enumerated(EnumType.STRING)
    val operacao: Operacao?,
    @field: Positive
    val valor: BigDecimal?,
    @field: NotNull
    val data: LocalDateTime?,
    @field: NotBlank
    val clienteId: String?,
    @field: NotBlank
    val conta: String?
) {
    fun toModel() : Extrato{
        return Extrato(
            operacao,
            valor,
            data,
            clienteId,
            conta
        )
    }

}
