package com.manager.patient.services;

import com.manager.patient.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatientservices {
    public List<PatientDto> userList();
    public PatientDto save(PatientDto patientDto);
    public PatientDto get( Integer id);
    public void delete(Integer id);
}
