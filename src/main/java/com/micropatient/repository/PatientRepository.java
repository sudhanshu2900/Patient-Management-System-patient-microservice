package com.micropatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micropatient.entity.Patient;

/**
 * JpaRepository (Java Persistence API): It contains the API for CRUD (Create,
 * Read, Update, Delete) operation on data. Here we used findByName() from
 * JpaRepository.
 * 
 * @author POD4
 *
 */
public interface PatientRepository extends JpaRepository<Patient,Integer>{

	Patient findByName(String name);

}
