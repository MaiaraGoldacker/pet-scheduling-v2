package br.com.pet.schedulling.mapper

import br.com.pet.schedulling.model.Pet
import br.com.pet.schedulling.model.Schedule
import br.com.pet.schedulling.response.PetResponse
import br.com.pet.schedulling.response.ScheduleResponse
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
class ScheduleMapper(){
    fun map(schedule: Schedule): ScheduleResponse {
        val scheduleResponse =  ScheduleResponse()
        BeanUtils.copyProperties(schedule, scheduleResponse);
        return scheduleResponse
    }
}
