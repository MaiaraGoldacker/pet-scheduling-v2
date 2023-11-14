package br.com.pet.schedulling.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Pet (
    val id: Long? = null,
    val name: String,
    var createDate: LocalDateTime = LocalDateTime.now(),
    var birthDate: LocalDate,
    var specie: PetSpecie

    ){


}