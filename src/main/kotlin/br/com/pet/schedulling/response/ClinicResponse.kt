package br.com.pet.schedulling.response

import java.time.LocalDateTime

data class ClinicResponse(
    var id: Long,
    var name: String,
    var cnpj: String,
    var createDate: LocalDateTime) {

    constructor() : this(0, "", "", LocalDateTime.now())
}
