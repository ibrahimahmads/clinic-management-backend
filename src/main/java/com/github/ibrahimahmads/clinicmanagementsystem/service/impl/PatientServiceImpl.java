package com.github.ibrahimahmads.clinicmanagementsystem.service.impl;

import com.github.ibrahimahmads.clinicmanagementsystem.entity.Patient;
import com.github.ibrahimahmads.clinicmanagementsystem.repository.PatientRepository;
import com.github.ibrahimahmads.clinicmanagementsystem.service.PatientService;
import com.github.ibrahimahmads.clinicmanagementsystem.utils.exceptions.DataValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {
        if(patientRepository.existsByPhoneNumber(patient.getPhoneNumber())){
            throw new DataValidationException("Patient with this phone number already exists");
        }
        return save(patient);
    }

    @Override
    public Patient findById(UUID id) {
        return patientRepository.findById(id).orElseThrow(() -> new DataValidationException("Patient not found"));
    }

    @Override
    public Patient update(Patient patient) {
        Patient patientToUpdate = findById(patient.getId());

        patientToUpdate.setNamePatient(patient.getNamePatient());
        patientToUpdate.setPhoneNumber(patient.getPhoneNumber());
        patientToUpdate.setGender(patient.getGender());
        patientToUpdate.setAddress(patient.getAddress());
        patientToUpdate.setBirthDate(patient.getBirthDate());

        return save(patientToUpdate);
    }

    @Override
    public void delete(UUID id) {
        Patient patient = findById(id);
        patientRepository.delete(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
