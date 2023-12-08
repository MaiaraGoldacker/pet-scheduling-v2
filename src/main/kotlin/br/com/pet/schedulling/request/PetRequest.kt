package br.com.pet.schedulling.request

import br.com.pet.schedulling.model.PetSpecie
import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class PetRequest(
        @field: NotNull val id: Long,
        @field: NotEmpty @Size(min = 5, max = 255) val name: String,
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd") @field: NotNull val birthDate: LocalDate,
        @field: NotNull val specie: PetSpecie) {
}