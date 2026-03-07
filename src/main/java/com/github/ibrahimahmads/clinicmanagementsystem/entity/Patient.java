package com.github.ibrahimahmads.clinicmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.ibrahimahmads.clinicmanagementsystem.utils.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "m_patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient extends BaseEntity{
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String namePatient;
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties("patient")
    private List<Queue> queueList = new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties("patient")
    private List<MedicalRecord> medicalRecordList = new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties("patient")
    private List<Billing> billingList = new ArrayList<>();
}
