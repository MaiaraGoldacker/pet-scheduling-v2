package br.com.pet.schedulling.mapper

import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.request.PetRequest
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
class PetRequestMapper: Mapper<PetRequest, Pet> {
    override fun map(petRequest: PetRequest): Pet {
        var pet =  Pet(0, "")
        BeanUtils.copyProperties(petRequest, pet)
        return pet
    }
}