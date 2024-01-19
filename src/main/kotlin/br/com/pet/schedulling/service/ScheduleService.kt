package br.com.pet.schedulling.service

import br.com.pet.schedulling.mapper.ScheduleMapper
import br.com.pet.schedulling.model.Clinic
import br.com.pet.schedulling.model.Schedule
import br.com.pet.schedulling.repository.ScheduleRepository
import br.com.pet.schedulling.request.PetRequest
import br.com.pet.schedulling.request.ScheduleRequest
import br.com.pet.schedulling.response.PetResponse
import br.com.pet.schedulling.response.ScheduleResponse
import org.springframework.stereotype.Service


@Service
class ScheduleService(private val repostiory: ScheduleRepository,
        private val petService : PetService,
        private val clinicService : ClinicService,
        private val scheduleMapper: ScheduleMapper) {

    fun save(scheduleRequest: ScheduleRequest): ScheduleResponse {

        val pet =  petService.getPet(scheduleRequest.petId)
        val clinic = clinicService.getClinic(scheduleRequest.clinicId)

        val endSchedule = scheduleRequest.startSchedule.plusMinutes(clinic.duration.toLong())

        val schedule =  Schedule();
        schedule.startSchedule = scheduleRequest.startSchedule
        schedule.endSchedule = endSchedule
        schedule.clinic = clinic
        schedule.pet = pet

        val savedObject = repostiory.save(schedule);
        return scheduleMapper.map(savedObject)
    }
}