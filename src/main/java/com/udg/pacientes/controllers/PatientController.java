package com.udg.pacientes.controllers;

import com.udg.pacientes.models.PatientModel;
import com.udg.pacientes.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientService service;

    @PostMapping()
    public PatientModel savePatient(@RequestBody PatientModel patient){
        return service.savePatient(patient);
    }

    @PutMapping()
    public PatientModel editPatient(@RequestBody PatientModel patient){
        return service.editPatient(patient);
    }

    @GetMapping()
    public ArrayList<PatientModel> getAllPatients(){
        return service.getAllPatients();
    }


    @GetMapping("/findPatientById/{id}")
    public Optional<PatientModel> findPatientById(@PathVariable Long id){
        return service.findPatientById(id);
    }

    @GetMapping("/findPatientByPhoneNumber/{phoneNumber}")
    public Optional<ArrayList<PatientModel>> finPatientByPhoneNumber(@PathVariable String phoneNumber){
        return service.findPatientByPhoneNumber(phoneNumber);
    }

    @GetMapping("/findPatientByName/{name}")
    public Optional<ArrayList<PatientModel>> findPatientByName(@PathVariable String name){
        return service.findPatientByName(name);
    }
    @DeleteMapping("/delete-patient-by-id")
    public String deletePatientById(@RequestParam("id") Long id){
        return service.deletePatientById(id);
    }

}
