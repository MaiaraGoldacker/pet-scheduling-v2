package br.com.pet.schedulling.mapper

import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.request.PetRequest
import br.com.pet.schedulling.response.PetResponse
import org.springframework.beans.BeanUtils
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
    fun mapAll(pets: List<Pet>): List<PetResponse> {
        val  list = ArrayList<PetResponse>()
        pets.forEach { list.add(map(it)) }
        return  list
    }
}
