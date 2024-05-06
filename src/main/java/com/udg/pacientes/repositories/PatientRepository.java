package com.udg.pacientes.repositories;

import com.udg.pacientes.models.PatientModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PatientRepository extends CrudRepository<PatientModel, Long> {

    public Optional<ArrayList<PatientModel>> findPatientModelByPhoneNumber(String phoneNumber);

    public Optional<ArrayList<PatientModel>> findPatientModelByName(String name);
}
