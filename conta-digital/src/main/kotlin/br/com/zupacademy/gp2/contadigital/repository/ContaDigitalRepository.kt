package br.com.zupacademy.gp2.contadigital.repository

import br.com.zupacademy.gp2.contadigital.model.ContaDigital
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface ContaDigitalRepository: CrudRepository<ContaDigital?, Long>{

    fun findByNumeroConta(numeroConta: String): Optional<ContaDigital>
}