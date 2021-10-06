package br.com.zupacademy.gp2.orquestrador

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.zupacademy.gp2.orquestrador")
		.start()
}

