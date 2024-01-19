package br.com.pet.schedulling.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
@Entity
data class Schedule(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(name = "start_schedule")
        var startSchedule: LocalDateTime,
        @Column(name = "end_schedule")
        var endSchedule: LocalDateTime,
        @Column(name = "create_date")
        var createDate: LocalDateTime = LocalDateTime.now(),
        @ManyToOne @JoinColumn(name = "pet_id", referencedColumnName = "id") var pet: Pet,
        @ManyToOne @JoinColumn(name = "clinic_id", referencedColumnName = "id") var clinic: Clinic
) {

        constructor() : this(null, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), Pet(), Clinic())
}
