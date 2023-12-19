package br.com.pet.schedulling.controller

import br.com.pet.schedulling.request.ClinicRequest
import br.com.pet.schedulling.response.ClinicResponse
import br.com.pet.schedulling.service.ClinicService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/clinics")
class ClinicController(private val service : ClinicService) {

    @PostMapping
    fun save(@Valid @RequestBody clinic: ClinicRequest,
             uriBuilder: UriComponentsBuilder): ResponseEntity<ClinicResponse> {
        val item = service.save(clinic)
        val uri = uriBuilder.path("/clinics/").build().toUri()

        return ResponseEntity.created(uri).body(item)
    }

    @GetMapping
    fun getAll(pageable : Pageable): Page<ClinicResponse> {
        return service.getAll(pageable)
    }
}