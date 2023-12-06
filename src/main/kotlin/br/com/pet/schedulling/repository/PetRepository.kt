package br.com.pet.schedulling.repository

import br.com.pet.schedulling.model.Pet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository:  JpaRepository<Pet, Long> {

}