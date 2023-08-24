package com.manager.patient.services;

import com.manager.patient.dao.IPatientRepository;
import com.manager.patient.dto.PatientDto;
import com.manager.patient.entities.Patient;
import com.manager.patient.exceptions.PatientNotFoundException;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor

public class PatientServiceImpl implements IPatientservices {
    private IPatientRepository repo;
    private ModelMapper modelMapper;

    public List<PatientDto> patientList() {
        return repo.findAll().stream().
                map(patient -> modelMapper.map(patient, PatientDto.class))
                .toList();

    }

    public PatientDto save(PatientDto patientDto) {
        if (!isValidPatientDto(patientDto)){
            throw new ServiceException("Some values are missing");
        }
        //transform patient dto to patient class
        Patient patient = modelMapper.map(patientDto, Patient.class);
        repo.save(patient);
        //transform patient dto to patient class
        return modelMapper.map(patient, PatientDto.class);
    }


    public PatientDto get(Integer id) {
        var patient = repo.findById(id).orElseThrow(()->new PatientNotFoundException("patient non trouve"));
        return modelMapper.map(patient, PatientDto.class);
    }


    public void delete(Integer id) {
        repo.deleteById(id);
    }
    public PatientDto update(PatientDto patientDto) {
        if(!isValidPatientDto(patientDto)) {
            throw new ServiceException("Some values are missing");
        }
        Patient patient = modelMapper.map(patientDto, Patient.class);
        repo.save(patient);
        return modelMapper.map(patient,PatientDto.class);
    }

    private boolean isValidPatientDto(PatientDto patientDto) {
        return patientDto != null && !patientDto.getFirstname().isEmpty()
                && !patientDto.getLastname().isEmpty()
                && !patientDto.getDateNaissance().toLocalDate().isAfter(LocalDate.now())
                && !patientDto.getEmail().isEmpty()
                && !patientDto.getPassword().isEmpty();
    }


}


