package br.com.pet.schedulling.response

import br.com.pet.schedulling.model.PetSpecie
import jakarta.persistence.Column
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.time.LocalDate
import java.time.LocalDateTime

data class PetResponse(
        var id: Long,
        var name: String,
        var createDate: LocalDateTime,
        var birthDate: LocalDate,
        var specie: PetSpecie
        ){
    constructor() : this(0, "", LocalDateTime.now(), LocalDate.now(), PetSpecie.DOG)
}
