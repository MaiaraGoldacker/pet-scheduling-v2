package br.com.pet.schedulling.mapper

import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.response.PetResponse
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
class PetResponseMapper: Mapper<Pet, PetResponse> {
    override fun map(pet: Pet): PetResponse {
        var petResponse =  PetResponse(0, "")
        BeanUtils.copyProperties(pet, petResponse);
        return petResponse
    }
}
