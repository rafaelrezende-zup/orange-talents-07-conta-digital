package br.com.zupacademy.gp2.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Email(
    @field: NotBlank
    val email: String
) {
    @field: Id
    @field: GeneratedValue
    var id: Long? = null

    val data: LocalDateTime = LocalDateTime.now()
}