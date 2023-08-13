package com.manager.patient.services;

import com.manager.patient.dao.IPatientRepository;
import com.manager.patient.dto.PatientDto;
import com.manager.patient.entities.Patient;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor

public class PatientServiceImpl implements IPatientservices {
    private IPatientRepository repo;
    private ModelMapper modelMapper;

    public List<PatientDto> userList() {
        return repo.findAll().stream().
                map(patient -> modelMapper.map(patient, PatientDto.class))
                .toList();

    }

    public PatientDto save(PatientDto patientDto) {
        //transform patient dto to patient class
        Patient patient = modelMapper.map(patientDto, Patient.class);
        repo.save(patient);
        //transform patient dto to patient class
        return modelMapper.map(patient, PatientDto.class);
    }


    public PatientDto get(Integer id) {
        Optional<Patient> patient = repo.findById(id);
        return modelMapper.map(patient, PatientDto.class);
    }


    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
