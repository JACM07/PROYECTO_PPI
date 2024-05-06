package com.udg.pacientes.services;

import com.udg.pacientes.models.PatientModel;
import com.udg.pacientes.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientRepository repository;

    //CRUD

    public PatientModel savePatient(PatientModel patient){
        if(repository.findPatientModelByPhoneNumber(patient.getPhoneNumber()).toString().equals("Optional[[]]")){
            return repository.save(patient);
        }else{
            //retornar un error de repetido
            PatientModel patientError = new PatientModel();
                patientError.setId(-1L);
            return patientError;
        }

    }

    public ArrayList<PatientModel> getAllPatients(){
        return (ArrayList<PatientModel>) repository.findAll();
    }

    public Optional<PatientModel> findPatientById(Long id){
        return repository.findById(id);
    }

    public PatientModel editPatient(PatientModel patient){
        return repository.save(patient);
    }

    public String deletePatientById(Long id){

        if(findPatientById(id).isPresent()){
            repository.deleteById(id);
            return "paciente eliminado exitosamente";
        }else {
            return "paciente con id= "+id+ " no encontrado";
        }
    }

    public Optional<ArrayList<PatientModel>> findPatientByPhoneNumber(String phoneNumber){
        return repository.findPatientModelByPhoneNumber(phoneNumber);
    }
    public Optional<ArrayList<PatientModel>> findPatientByName(String name){
        return repository.findPatientModelByName(name);
    }
}
