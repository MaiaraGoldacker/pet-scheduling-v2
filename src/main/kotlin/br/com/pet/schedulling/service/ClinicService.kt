package br.com.pet.schedulling.service

import br.com.pet.schedulling.exception.NotFoundException
import br.com.pet.schedulling.mapper.ClinicMapper
import br.com.pet.schedulling.model.Clinic
import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.repository.ClinicRepository
import br.com.pet.schedulling.request.ClinicRequest
import br.com.pet.schedulling.response.ClinicResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ClinicService(private val repository: ClinicRepository,
                    private val  mapper: ClinicMapper) {
    fun save(bathGroomingClinicRequest: ClinicRequest): ClinicResponse {
        val clinic = mapper.map(bathGroomingClinicRequest)
        return mapper.map(repository.save(clinic))
    }

    fun getAll(pageable : Pageable): Page<ClinicResponse> {
        val pageableList =  repository.findAll(pageable);
        return mapper.mapAll(pageableList)
    }
    fun getClinic(id:Long): Clinic {
        val optionalPet = repository.findById(id)

        if (optionalPet.isEmpty) throw NotFoundException("Clinic not found")

        return optionalPet.get()
    }
}