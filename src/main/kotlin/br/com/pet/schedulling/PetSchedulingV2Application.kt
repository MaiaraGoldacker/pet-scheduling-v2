package br.com.pet.schedulling

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PetSchedulingV2Application

fun main(args: Array<String>) {
	runApplication<PetSchedulingV2Application>(*args)
}
