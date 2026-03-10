package com.github.ibrahimahmads.clinicmanagementsystem.service;

import com.github.ibrahimahmads.clinicmanagementsystem.dto.request.patient.PatientRequest;
import com.github.ibrahimahmads.clinicmanagementsystem.entity.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    Patient save(PatientRequest payload);
    Patient findById(UUID id);
    void delete(UUID id);
    Patient update(UUID id,PatientRequest payload);
    List<Patient> findAll();
}
