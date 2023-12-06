package br.com.pet.schedulling.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Pet (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String
   // var createDate: LocalDateTime = LocalDateTime.now(),
    //var birthDate: LocalDate,
   // var specie: PetSpecie

    ){


}