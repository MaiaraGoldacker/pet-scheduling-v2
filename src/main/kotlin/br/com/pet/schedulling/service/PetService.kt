package br.com.pet.schedulling.service

import br.com.pet.schedulling.exception.NotFoundException
import br.com.pet.schedulling.mapper.PetRequestMapper
import br.com.pet.schedulling.mapper.PetResponseMapper
import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.repository.PetRepository
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
class PetService(private val repository: PetRepository,
                 var petRequestMapper: PetRequestMapper,
                 var petResponseMapper: PetResponseMapper) {

    fun getAll(): List<Pet>{
       return repository.findAll();
    }

    fun getById(id: Long): PetResponse {
        return  petResponseMapper.map(
                getPet(id)
             )
    }

    private fun getPet(id:Long): Pet{
        return repository.getOne(id)
    }

    fun save(petRequest: PetRequest): PetResponse {
        val pet = petRequestMapper.map(petRequest)
        return petResponseMapper.map(repository.save(pet))
    }
    fun update(id: Long,  petRequest: PetRequest): PetResponse {
        val petFound = getPet(id)
        petFound.name = petRequest.name
        return petResponseMapper.map(repository.save(petFound))
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}