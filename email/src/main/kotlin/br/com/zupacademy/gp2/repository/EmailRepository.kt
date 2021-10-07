package br.com.zupacademy.gp2.repository

import br.com.zupacademy.gp2.model.Email
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface EmailRepository : JpaRepository<Email, Long> {
}