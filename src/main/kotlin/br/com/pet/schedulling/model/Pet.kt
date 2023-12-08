package br.com.pet.schedulling.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Pet (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    @Column(name = "create_date")
    var createDate: LocalDateTime = LocalDateTime.now(),
    @Column(name = "birth_date")
    var birthDate: LocalDate,
    @Enumerated(EnumType.STRING)
    var specie: PetSpecie
    ){
    constructor() : this(null, "", LocalDateTime.now(), LocalDate.now(), PetSpecie.DOG)

}