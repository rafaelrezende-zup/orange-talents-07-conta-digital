package br.com.zupacademy.gp2.contadigital

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.zupacademy.gp2")
		.start()
}

