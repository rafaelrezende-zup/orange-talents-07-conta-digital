package br.com.zupacademy.gp2.contadigital.controller

import br.com.zupacademy.gp2.contadigital.dto.OperacaoRequest
import br.com.zupacademy.gp2.contadigital.repository.ContaDigitalRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.HttpResponse
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Controller("/api/v1/contadigital/{numero}")
@Validated
class ContaDigitalController (
    val repository: ContaDigitalRepository
    ){

    @Post("/creditar")
    @Transactional
    fun creditar(@PathVariable("numero") numeroConta: String,@Valid @Body request: OperacaoRequest): HttpResponse<Any?> {

        val possivelConta = repository.findByNumeroConta(numeroConta)
        if(possivelConta.isEmpty){
            return HttpResponse.notFound()
        }

        val conta = possivelConta.get()
        conta.creditar(request.valor)
        return HttpResponse.ok()
    }
}