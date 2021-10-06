package br.com.zupacademy.gp2.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
class Extrato (
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
    ){
    @field: Id
    @field: GeneratedValue
    var id: Long? = null
}