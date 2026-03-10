package com.github.ibrahimahmads.clinicmanagementsystem.controller;

import com.github.ibrahimahmads.clinicmanagementsystem.dto.request.patient.PatientRequest;
import com.github.ibrahimahmads.clinicmanagementsystem.dto.response.patient.PatientResponse;
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
    public ResponseEntity<PatientResponse> savePatient(@RequestBody PatientRequest payload){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.save(payload).toResponse());
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientResponse> getById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(patientService.findById(id).toResponse());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable("id") UUID id, @RequestBody PatientRequest payload){
        return ResponseEntity.ok(patientService.update(id,payload).toResponse());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") UUID id){
        patientService.delete(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
