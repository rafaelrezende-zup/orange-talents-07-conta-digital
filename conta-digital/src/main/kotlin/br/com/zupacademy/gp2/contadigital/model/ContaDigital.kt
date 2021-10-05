package br.com.zupacademy.gp2.contadigital.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
class ContaDigital (
    @field:Column(nullable = false,unique = true)
    val numeroConta: String,
    @field:Column(nullable = false)
    val idCliente: String,
    saldo: BigDecimal
    ){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    var saldo: BigDecimal = saldo
        private set

    fun creditar(valor: BigDecimal){
        if(valor <= BigDecimal.ZERO){
            throw IllegalArgumentException("valor deve ser positivo.")
        }
        this.saldo += valor
    }

    fun debitar(valor: BigDecimal){
        if(valor <= BigDecimal.ZERO){
            throw IllegalArgumentException("valor deve ser positivo.")
        }
        if(valor > saldo){
            throw IllegalArgumentException("valor a ser debitado é maior que o saldo.")
        }
        this.saldo -= valor
    }
}