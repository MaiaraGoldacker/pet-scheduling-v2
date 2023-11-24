package br.com.pet.schedulling.service

import br.com.pet.schedulling.exception.NotFoundException
import br.com.pet.schedulling.mapper.PetRequestMapper
import br.com.pet.schedulling.mapper.PetResponseMapper
import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.request.PetRequest
import br.com.pet.schedulling.response.PetResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import java.util.stream.Collectors

@Service
class PetService(var petList: List<Pet> = ArrayList(),
                 var petRequestMapper: PetRequestMapper,
                 var petResponseMapper: PetResponseMapper) {

    fun getAll(): List<Pet>{
       return petList
    }

    fun getById(id: Long): PetResponse {
        return  petResponseMapper.map(
                getPet(id)
             )
    }

    private fun getPet(id:Long): Pet{
      val petService = petList.stream().filter {
            p -> p.id == id
        }.findFirst().orElseThrow{(NotFoundException("PetService not found"))}

        return petService
    }

    fun save(petRequest: PetRequest): PetResponse {
        val pet = petRequestMapper.map(petRequest)
        petList = petList.plus(pet)
        return petResponseMapper.map(pet)
    }
    fun update(id: Long,  petRequest: PetRequest): PetResponse {
        delete(id)
        return save(petRequest)
    }

    fun delete(id: Long) {
        val item = getPet(id)
        petList = petList.minus(item)
    }

}