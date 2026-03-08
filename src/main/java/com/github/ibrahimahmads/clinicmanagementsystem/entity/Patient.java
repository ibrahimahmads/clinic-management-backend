package com.github.ibrahimahmads.clinicmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.ibrahimahmads.clinicmanagementsystem.utils.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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

    @NotBlank(message = "Name can not be empty")
    private String namePatient;
    @NotNull(message = "Birth date can not be empty")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @NotNull(message = "Gender can not be empty")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotBlank(message = "Phone number can not be empty")
    private String phoneNumber;
    @NotBlank(message = "Address can not be empty")
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
