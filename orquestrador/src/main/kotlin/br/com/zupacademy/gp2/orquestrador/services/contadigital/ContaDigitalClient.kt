package br.com.zupacademy.gp2.orquestrador.services.contadigital

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import javax.validation.Valid

@Client("\${services.contadigital.baseUri}")
interface ContaDigitalClient {
    @Post("\${services.contadigital.credita.urn}")
    fun credita(@PathVariable numeroConta: String, @Body @Valid operacaoRequest: OperacaoRequest)

    @Post("\${services.contadigital.debita.urn}")
    fun debita(@PathVariable numeroConta: String, @Body @Valid operacaoRequest: OperacaoRequest)
}
