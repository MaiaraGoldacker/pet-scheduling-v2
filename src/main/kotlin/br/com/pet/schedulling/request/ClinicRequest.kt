package br.com.pet.schedulling.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class ClinicRequest(@field: NotEmpty @Size(min = 5, max = 255) val name: String,
                         @field: NotEmpty @Size(min = 14, max = 14) val cnpj: String) {
}