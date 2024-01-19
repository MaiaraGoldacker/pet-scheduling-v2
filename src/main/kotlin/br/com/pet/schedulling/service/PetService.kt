package br.com.pet.schedulling.service

import br.com.pet.schedulling.exception.NotFoundException
import br.com.pet.schedulling.mapper.PetMapper
import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.repository.PetRepository
import br.com.pet.schedulling.request.PetRequest
import br.com.pet.schedulling.response.PetResponse
import org.springframework.beans.BeanUtils
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PetService(private val repository: PetRepository,
                 private val petMapper: PetMapper) {

    fun getAll(pageable : Pageable): Page<PetResponse> {
        val pageableList =  repository.findAll(pageable);
        return petMapper.mapAll(pageableList)
    }

    fun getById(id: Long): PetResponse {
        return  petMapper.map(getPet(id))
    }

    fun getPet(id:Long): Pet {
        val optionalPet = repository.findById(id)

        if (optionalPet.isEmpty) throw NotFoundException("Pet not found")

        return optionalPet.get()
    }

    fun save(petRequest: PetRequest): PetResponse {
        val pet = petMapper.map(petRequest)
        return petMapper.map(repository.save(pet))
    }
    fun update(id: Long,  petRequest: PetRequest): PetResponse {
        val petFound = getPet(id)

        BeanUtils.copyProperties(petRequest, petFound);
        petFound.id = id

        return petMapper.map(repository.save(petFound))
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}