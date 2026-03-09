package com.github.ibrahimahmads.clinicmanagementsystem.controller;

import com.github.ibrahimahmads.clinicmanagementsystem.entity.Patient;
import com.github.ibrahimahmads.clinicmanagementsystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping(value = "/save")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.save(patient));
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Patient> getById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") UUID id, @RequestBody Patient patient){
        patient.setId(id);
        return ResponseEntity.ok(patientService.update(patient));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") UUID id){
        patientService.delete(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
