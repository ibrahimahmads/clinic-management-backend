package com.github.ibrahimahmads.clinicmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "t_medical_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalRecord extends BaseCreatedEntity{
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "docter_id")
    private Docter docter;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String diagnosis;
    private String note;

    @OneToMany(mappedBy = "medicalRecord")
    private List<Prescription> prescriptionList = new ArrayList<>();

    @OneToOne(mappedBy = "medicalRecord")
    @JsonIgnoreProperties("billing")
    private Billing billing;
}
