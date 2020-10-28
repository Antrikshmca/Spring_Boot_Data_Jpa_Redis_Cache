package com.antriksh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4780783357749924450L;
	@Id
	@GeneratedValue
	private Integer empId;
	private String empName;
	private Double empSal;
}
