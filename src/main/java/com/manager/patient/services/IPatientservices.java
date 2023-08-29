package com.manager.patient.services;

import com.manager.patient.dto.PatientDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatientservices {
    public Page<PatientDto> findPaginated(int num_page, int nom_page,String keyword);
    public List<PatientDto> findListpatient(int pageNo, int pageSize);
    public PatientDto save(PatientDto patientDto);
    public PatientDto get( Integer id);
    public void delete(Integer id);
    public PatientDto update(PatientDto patientDto);
}
