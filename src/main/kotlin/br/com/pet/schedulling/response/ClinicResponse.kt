package br.com.pet.schedulling.response

import java.time.LocalDateTime

data class ClinicResponse(
    var id: Long,
    var name: String,
    var cnpj: String,
    var duration: Int,
    var createDate: LocalDateTime) {

    constructor() : this(0, "", "", 0, LocalDateTime.now())
}
