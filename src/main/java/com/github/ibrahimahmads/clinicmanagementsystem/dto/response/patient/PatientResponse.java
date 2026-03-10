package com.github.ibrahimahmads.clinicmanagementsystem.dto.response.patient;

import com.github.ibrahimahmads.clinicmanagementsystem.utils.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PatientResponse {
    private String name;
    private String phoneNumber;
    private Gender gender;
    private LocalDate birthDate;
    private String address;
}
