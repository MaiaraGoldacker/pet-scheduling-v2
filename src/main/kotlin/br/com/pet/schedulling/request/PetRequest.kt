package br.com.pet.schedulling.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class PetRequest(
        @field: NotNull val id: Long,
        @field: NotEmpty @Size(min = 5, max = 255) val name: String) {
}