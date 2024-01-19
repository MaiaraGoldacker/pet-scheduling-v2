package br.com.pet.schedulling.response

import br.com.pet.schedulling.model.Clinic
import br.com.pet.schedulling.model.Pet
import java.time.LocalDateTime

data class ScheduleResponse(var id: Long,
                            var startSchedule: LocalDateTime,
                            var endSchedule: LocalDateTime,
                            var petResponse : PetResponse,
                            var clinicResponse : ClinicResponse) {
    constructor() : this(0, LocalDateTime.now(), LocalDateTime.now(), PetResponse(), ClinicResponse())
}