package com.manager.patient.dto;

import com.manager.patient.entities.Consulte;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PatientDto {
    private Integer id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private Date dateNaissance;
    private String allergies;
    private String antecedent;
    private Boolean enable;

}


