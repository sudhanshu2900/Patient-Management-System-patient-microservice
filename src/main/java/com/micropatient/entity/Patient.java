package com.micropatient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Patient class define the patient entity by defining their attribute.
 * Here we send the data to H2 Database in "PATIENT_TBL" table.
 * We also defined the column name by using @Column annotation
 * @author POD4
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PATIENT_TBL")
@ApiModel(description="Details about the patient")
public class Patient {
	
	   /**
	    * @Id annotation is used for defining primary key.
	    * Here we are used @GeneratedValue annotation to increment the 'id' column.
	    */
	
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @ApiModelProperty(notes="Unique id of a patient")
	   private int id;
       
       @Column(name="name")
       @ApiModelProperty(notes="Patient's name")
	   private String name;
       
       @Column(name="age")
       @ApiModelProperty(notes="Patient's age")
	   private int age;
       
       @Column(name="gender")
       @ApiModelProperty(notes="Patient's gender")
	   private String gender;
       
       @Column(name="contact_no")
       @ApiModelProperty(notes="Patient's contact number")
	   private int contact_no;
       
       @Column(name="address")
       @ApiModelProperty(notes="Patient's address")
	   private String address;
       
       @Column(name="diaease")
       @ApiModelProperty(notes="Patient suffer from this disease")
	   private String disease;
       
       @Column(name="specialist_assigned")
       @ApiModelProperty(notes="Doctor assigned to the patient")
	   private String specialist_assigned;
       
       @Column(name="status")
       @ApiModelProperty(notes="Patient's current status")
	   private String status;
	   
}
