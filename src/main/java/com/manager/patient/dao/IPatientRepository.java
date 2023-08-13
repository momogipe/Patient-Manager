package com.manager.patient.dao;

import com.manager.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface  IPatientRepository extends JpaRepository<Patient,Integer> {
        public  Long countByid(Integer id);
        boolean existsById(Long id);
        Optional<Patient> findVoyageByFirstname(String nom);
}
