package com.github.ibrahimahmads.clinicmanagementsystem.service.impl;

import com.github.ibrahimahmads.clinicmanagementsystem.dto.request.patient.PatientRequest;
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
    public Patient save(PatientRequest payload) {
        if(patientRepository.existsByPhoneNumber(payload.getPhoneNumber())){
            throw new DataValidationException("Patient with this phone number already exists");
        }
        Patient patient = Patient.builder()
                .namePatient(payload.getName())
                .phoneNumber(payload.getPhoneNumber())
                .gender(payload.getGender())
                .address(payload.getAddress())
                .birthDate(payload.getBirthDate())
                .build();
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(UUID id) {
        return patientRepository.findById(id).orElseThrow(() -> new DataValidationException("Patient not found"));
    }

    @Override
    public Patient update(UUID id,PatientRequest payload) {
        Patient patientToUpdate = findById(id);

        patientToUpdate.setNamePatient(payload.getName());
        patientToUpdate.setPhoneNumber(payload.getPhoneNumber());
        patientToUpdate.setGender(payload.getGender());
        patientToUpdate.setAddress(payload.getAddress());
        patientToUpdate.setBirthDate(payload.getBirthDate());

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
