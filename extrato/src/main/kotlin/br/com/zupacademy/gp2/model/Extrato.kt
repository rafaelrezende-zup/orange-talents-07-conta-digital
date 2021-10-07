package br.com.zupacademy.gp2.model

import br.com.zupacademy.gp2.controller.Operacao
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
class Extrato (
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
    ){
    @field: Id
    @field: GeneratedValue
    var id: Long? = null
}