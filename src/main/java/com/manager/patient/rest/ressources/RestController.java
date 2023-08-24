package com.manager.patient.rest.ressources;

import com.manager.patient.dto.PatientDto;
import com.manager.patient.exceptions.BadRequestException;
import com.manager.patient.exceptions.Message;
import com.manager.patient.exceptions.NotFoundException;
import com.manager.patient.exceptions.PatientNotFoundException;
import com.manager.patient.services.IPatientservices;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("patient")
public class RestController {
    IPatientservices patientservices;
    @GetMapping("/patient/{id}")
    public PatientDto findpatientById(@PathVariable("id") Integer id) {
        try {
            return patientservices.get(id);
        } catch(com.manager.patient.exceptions.ServiceException exception) {
            throw new PatientNotFoundException("An error occurs while finding a person");
        }
    }

    @GetMapping("/persons")
    public List<PatientDto> findPersons() {
        return patientservices.patientList();
    }

    @PostMapping("/persons")
    public PatientDto createPerson(@RequestBody PatientDto patientdto) {
        try {
            return patientservices.save(patientdto);
        } catch(com.manager.patient.exceptions.ServiceException exception) {
            throw new NotFoundException("An error occurs while creating a person", exception);
        }
    }

    @PutMapping("/persons")
    public PatientDto updatePerson(@RequestBody PatientDto patientDto) {
        try {
            return patientservices.update(patientDto);
        } catch(ServiceException exception) {
            throw new BadRequestException("An error occurs while updating a person", exception);
        }
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Message> deletePerson(@PathVariable("id") Integer id) {
        try {
            patientservices.delete(id);
            var message = new Message(HttpStatus.OK,
                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    String.format("Person with id %s as been deleted", id));
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch(ServiceException exception) {
            throw new NotFoundException("An error occurs while deleting a person", exception);
        }
    }

}
