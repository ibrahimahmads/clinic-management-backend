package com.github.ibrahimahmads.clinicmanagementsystem.repository;

import com.github.ibrahimahmads.clinicmanagementsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByPhoneNumber(String phoneNumber);
}
