package com.manager.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
    private Integer id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private Date dateNaissance;
    private Boolean enable;
}
