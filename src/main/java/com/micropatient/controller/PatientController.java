package com.micropatient.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micropatient.entity.Patient;
import com.micropatient.service.PatientService;

/**
 * CrossOrigin is require for connection of frontend and backend so that data
 * display on frontend. RestController is an annotation for RESTful web
 * services.
 * 
 * @author POD4
 * 
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patients")
public class PatientController {

	/**
	 * Autowired is used for creating object of a class and from this we can use its
	 * members. Here 'service' is object of "PatientService".
	 */

	@Autowired
	private PatientService service;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	/**
	 * Return the details of all the patients
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<Patient> findAllPatients() {
		LOGGER.info("findALLpatients method is running");
		LOGGER.info("findALLPatients method is ended");
		return service.getPatients();
	}

	/**
	 * Return the detail of patient have ID=id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Patient findPatientById(@PathVariable int id) {
		LOGGER.info("findPatientById method is running");
		LOGGER.info("findPatientById method is ended ");
		return service.getPatientById(id);
	}

	/**
	 * Create a new patient
	 * 
	 * @param patient
	 * @return
	 */
	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient) {
		LOGGER.info("addPatient method is running ");
		LOGGER.info("addPatient method is ended ");
		return service.savePatient(patient);
	}

	/**
	 * Update the details of Patient
	 * 
	 * @param patient
	 * @return
	 */
	@PutMapping("/update")
	public Patient updatePatient(@RequestBody Patient patient) {
		LOGGER.info("updatePatient method is running");
		LOGGER.info("updatePatient method is ended");
		return service.updatePatient(patient);
	}

	/**
	 * Delete a patient with ID=id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public String deletePatient(@PathVariable int id) {
		LOGGER.info("deletePatient method is running");
		LOGGER.info("deletePatient method is ended");
		return service.deletePatient(id);
	}

}
