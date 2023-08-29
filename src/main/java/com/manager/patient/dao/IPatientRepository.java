package com.manager.patient.dao;

import com.manager.patient.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface  IPatientRepository extends JpaRepository<Patient,Integer> {
        Page<Patient> findByFirstnameContains(String keyword, Pageable pageable);
}
