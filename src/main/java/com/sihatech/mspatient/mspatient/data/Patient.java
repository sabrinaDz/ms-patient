package com.sihatech.mspatient.mspatient.data;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Long socialSecurityNumber;
    private Double weight;
    private Double size;


    /*
    FOREIGN KEYS
     */


}
