package br.com.zupacademy.gp2.repository

import br.com.zupacademy.gp2.model.Extrato
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable

@Repository
interface ExtratoRepository : JpaRepository<Extrato, Long> {
    fun findAllByContaOrderByDataDesc(conta : String, pageable: Pageable): Page<Extrato>
    fun existsByConta(conta : String): Boolean
}