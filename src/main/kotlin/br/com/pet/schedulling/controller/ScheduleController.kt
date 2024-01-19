package br.com.pet.schedulling.controller

import br.com.pet.schedulling.model.Schedule
import br.com.pet.schedulling.request.PetRequest
import br.com.pet.schedulling.request.ScheduleRequest
import br.com.pet.schedulling.response.PetResponse
import br.com.pet.schedulling.response.ScheduleResponse
import br.com.pet.schedulling.service.PetService
import br.com.pet.schedulling.service.ScheduleService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/schedules")
class ScheduleController(private val service: ScheduleService) {

    @PostMapping
    fun save(@Valid @RequestBody schedule: ScheduleRequest,
             uriBuilder: UriComponentsBuilder): ResponseEntity<ScheduleResponse> {
        val item = service.save(schedule)
        val uri = uriBuilder.path("/schedules/").build().toUri()

        return ResponseEntity.created(uri).body(item)
    }
}