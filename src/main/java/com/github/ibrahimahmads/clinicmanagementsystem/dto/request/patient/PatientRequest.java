package com.github.ibrahimahmads.clinicmanagementsystem.dto.request.patient;

import com.github.ibrahimahmads.clinicmanagementsystem.utils.enums.Gender;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PatientRequest {
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private String phoneNumber;
    private String address;
}
