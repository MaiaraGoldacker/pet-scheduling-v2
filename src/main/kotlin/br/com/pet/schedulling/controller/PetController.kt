package br.com.pet.schedulling.controller

import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.request.PetRequest
import br.com.pet.schedulling.response.PetResponse
import br.com.pet.schedulling.service.PetService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/pets")
class PetController(private val service: PetService){

    @GetMapping
    fun getAll(): List<PetResponse>{
        return service.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): PetResponse {
        return service.getById(id)
    }

    @PostMapping
    fun save(@Valid @RequestBody pet: PetRequest,
             uriBuilder: UriComponentsBuilder): ResponseEntity<PetResponse> {
        val item = service.save(pet)
        val uri = uriBuilder.path("/topicos/").build().toUri()

        return ResponseEntity.created(uri).body(item)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
            @Valid @RequestBody pet: PetRequest): PetResponse {
        return service.update(id, pet)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}

