package br.com.zupacademy.gp2.controller

import br.com.zupacademy.gp2.repository.ExtratoRepository
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import jakarta.inject.Inject
import javax.validation.Valid

@Controller("/transacoes")
@Validated
class ExtratoController(@Inject val repository: ExtratoRepository) {

    @Post
    fun cadastra(@Valid @Body request: TransacaoRequest) : HttpResponse<Any>{
        val conta = repository.save(request.toModel())

        return HttpResponse.created(HttpResponse.uri("/transacoes/${conta.id}"))
    }

    @Get("/{contaId}")
    fun listar(@PathVariable contaId : String, pageable: Pageable) : HttpResponse<Any> {
        val existeConta = repository.existsByConta(contaId)

        if(!existeConta)
            return HttpResponse.badRequest()

        val extratos = repository.findAllByContaOrderByDataDesc(contaId, pageable)

        val response = extratos.map{
            TransacaoResponse(it.operacao,it.valor,it.data)
        }

        return HttpResponse.ok(response)

    }
}