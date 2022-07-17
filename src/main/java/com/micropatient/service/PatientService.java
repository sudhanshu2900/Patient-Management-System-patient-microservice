package com.micropatient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micropatient.entity.Patient;
import com.micropatient.repository.PatientRepository;

/**
 * PatientService class contains some methods that use JpaRepository functions and perform some operations.
 * Here we define the function for creating, writing, deleting, updating data.
 * @author POD4
 *
 */
@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;

	public Patient savePatient(Patient patient) {
		return repository.save(patient);
	}

	public List<Patient> getPatients() {
		return repository.findAll();
	}

	public Patient getPatientById(int id) {
		return repository.findById(id).orElse(null);
	}

	public String deletePatient(int id) {
		repository.deleteById(id);
		return "Patient with ID " + id +" is removed";
	}

	public Patient updatePatient(Patient patient) {
		Patient existingPatient = repository.findById(patient.getId()).orElse(null);
		existingPatient.setName(patient.getName());
		existingPatient.setAge(patient.getAge());
		existingPatient.setGender(patient.getGender());
		existingPatient.setContact_no(patient.getContact_no());
		existingPatient.setAddress(patient.getAddress());
		existingPatient.setDisease(patient.getDisease());
		existingPatient.setSpecialist_assigned(patient.getSpecialist_assigned());
		existingPatient.setStatus(patient.getStatus());
		return repository.save(existingPatient);
	}

}
