package com.github.ibrahimahmads.clinicmanagementsystem.service;

import com.github.ibrahimahmads.clinicmanagementsystem.entity.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    Patient save(Patient patient);
    Patient findById(UUID id);
    void delete(UUID id);
    Patient update(Patient patient);
    List<Patient> findAll();
}
