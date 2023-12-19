package br.com.pet.schedulling.mapper

import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.request.PetRequest
import br.com.pet.schedulling.response.PetResponse
import org.springframework.beans.BeanUtils
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import java.util.ArrayList

@Component
class PetMapper {
    fun map(petRequest: PetRequest): Pet {
        val pet =  Pet();
        BeanUtils.copyProperties(petRequest, pet)
        return pet
    }
    fun map(pet: Pet): PetResponse {
        val petResponse =  PetResponse()
        BeanUtils.copyProperties(pet, petResponse);
        return petResponse
    }
    fun mapAll(pets: Page<Pet>): Page<PetResponse> {
       return pets.map { map(it) }
    }
}
