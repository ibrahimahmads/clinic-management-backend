package com.github.ibrahimahmads.clinicmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.ibrahimahmads.clinicmanagementsystem.utils.enums.BillingStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "t_billing")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Billing extends BaseCreatedEntity{
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @OneToOne(mappedBy = "billing")
    @JsonIgnoreProperties("medicalRecord")
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Double consultationFee;
    private Double medicineFee;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private BillingStatus status;
}
