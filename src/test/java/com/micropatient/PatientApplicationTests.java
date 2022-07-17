package com.micropatient;

import org.junit.runner.RunWith;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.internal.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.micropatient.entity.Patient;
import com.micropatient.repository.PatientRepository;
import com.micropatient.service.PatientService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientApplicationTests {

	@MockBean
	private PatientRepository repository;
	
	@Autowired
	private PatientService service;
	
	/**
	 * Checking for get all patients
	 */
	@Test
	public void getPatientsTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Patient(1,"Sudhanshu", 21, "Male", 941234567, "SWM", "ENT", "Dr. Priyanka", "NIL")).collect(Collectors.toList()));
		assertEquals(1, service.getPatients().size());
	}
	
	/**
	 * Checking for save patient in database
	 */
	@Test
	public void savePatientTest() {
		Patient patient = new Patient(1,"Keshav", 22, "Male", 991234569, "JPR", "Heart", "Dr. Shivam", "NIL");
		when(repository.save(patient)).thenReturn(patient);
		assertEquals(patient, service.savePatient(patient));
	}
		
	/**
	 * Checking weather patient is deleted from database or not
	 */
	@Test
	public void deletePatientTest() {		
		Patient patient = new Patient(1,"Keshav", 22, "Male", 991234569, "JPR", "Heart", "Dr. Shivam", "NIL");
		int id = 1;
		service.deletePatient(id);
		assertEquals(0, service.getPatients().size());
	}
	
	
}
