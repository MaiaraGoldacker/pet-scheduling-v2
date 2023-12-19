package br.com.pet.schedulling.mapper

import br.com.pet.schedulling.model.Clinic
import br.com.pet.schedulling.request.ClinicRequest
import br.com.pet.schedulling.response.ClinicResponse
import org.springframework.beans.BeanUtils
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component


@Component
class ClinicMapper {

    fun map(bathGroomingClinicRequest: ClinicRequest): Clinic {
        val bathGroomingClinic =  Clinic();
        BeanUtils.copyProperties(bathGroomingClinicRequest, bathGroomingClinic)
        return bathGroomingClinic
    }
    fun map(bathGroomingClinic: Clinic): ClinicResponse {
        val bathGroomingClinicResponse =  ClinicResponse()
        BeanUtils.copyProperties(bathGroomingClinic, bathGroomingClinicResponse);
        return bathGroomingClinicResponse
    }
    fun mapAll(clinics: Page<Clinic>): Page<ClinicResponse> {
        return clinics.map { map(it) }
    }
}