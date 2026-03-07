package com.github.ibrahimahmads.clinicmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "m_medicine")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medicine extends BaseEntity{
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String nameMedicine;
    private Integer stock;
    private Double price;
}
