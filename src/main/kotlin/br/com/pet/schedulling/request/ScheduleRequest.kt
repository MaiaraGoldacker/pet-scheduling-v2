package br.com.pet.schedulling.request

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

data class ScheduleRequest(@field: NotNull var petId: Long,
                           @field: NotNull val clinicId: Long,
                           @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
                           @field: NotNull val startSchedule: LocalDateTime
                           ){

}
