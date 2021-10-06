package br.com.zupacademy.gp2.orquestrador.controller

import br.com.zupacademy.gp2.orquestrador.services.kafka.TransacaoClient
import br.com.zupacademy.gp2.orquestrador.services.contadigital.ContaDigitalClient
import br.com.zupacademy.gp2.orquestrador.services.contadigital.OperacaoRequest
import br.com.zupacademy.gp2.orquestrador.services.kafka.Operacoes
import br.com.zupacademy.gp2.orquestrador.services.kafka.TransacaoProducer
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.exceptions.HttpClientException
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import javax.validation.Valid

@Controller("/api/v1/contaddigital/{numeroConta}")
@Validated
class TransacaoController(
        val contaDigitalClient: ContaDigitalClient,
        val transacaoClient: TransacaoClient
)
{

    val logger = LoggerFactory.getLogger(this.javaClass)

    @Post("/credita")
    fun credita(@PathVariable numeroConta:String, @Valid transacaoRequest: TransacaoRequest): HttpResponse<Unit> {

        try {
            val response = this.contaDigitalClient.credita(
                    numeroConta,
                    OperacaoRequest(
                            transacaoRequest.valor
                    )
            )

            this.transacaoClient.sendTrasacao(
                    TransacaoProducer(
                            operacao = Operacoes.CREDITO,
                            valor = transacaoRequest.valor,
                            data = LocalDateTime.now(),
                            clienteId = transacaoRequest.clienteId,
                            conta = numeroConta
                    )
            )

            return HttpResponse.ok()
        } catch(excption: HttpClientException) {
            logger.error(excption.message)
            return HttpResponse.badRequest()
        }
    }

    @Post("/debita")
    fun debita(@PathVariable numeroConta:String, @Valid transacaoRequest: TransacaoRequest): HttpResponse<Unit> {
        try {
            val response = this.contaDigitalClient.credita(
                    numeroConta,
                    OperacaoRequest(
                            transacaoRequest.valor
                    )
            )

            this.transacaoClient.sendTrasacao(
                    TransacaoProducer(
                            operacao = Operacoes.DEBITO,
                            valor = transacaoRequest.valor,
                            data = LocalDateTime.now(),
                            clienteId = transacaoRequest.clienteId,
                            conta = numeroConta
                    )
            )

            return HttpResponse.ok()
        } catch(excption: HttpClientException) {
            logger.error(excption.message)
            return HttpResponse.badRequest()
        }
    }

}