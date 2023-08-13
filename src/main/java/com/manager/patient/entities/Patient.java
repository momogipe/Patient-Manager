package com.manager.patient.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true,length = 45)
    private String email;
    @Column(length = 15,nullable = false)
    private String password;
    @Column(length = 45,nullable = false,name = "firsname")
    private String firstname;
    @Column(length = 45,nullable = false,name = "Lastname")
    private String lastname;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private Boolean enable;
}
