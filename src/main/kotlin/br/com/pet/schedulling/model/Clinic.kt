package br.com.pet.schedulling.model

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
data class Clinic(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String,
        var cnpj: String,
        @Column(name = "create_date")
        var createDate: LocalDateTime = LocalDateTime.now(),
        var duration: Int) {
    constructor() : this(null, "", "", LocalDateTime.now(), 0)
}