package com.simactivation.Entity;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.simactivation.Enum.Id_Type;

import java.time.LocalDate;


import javax.persistence.*;

@Entity
@Table(name="customer")
@JsonIgnoreProperties(value= {"details","address"})
public class Customer {

	
	
	@Id
	@Length(max=16)
	@Column(name="uniqueIdNumber")
	private String uniqueIdNumber;
	
	
	@Past(message="Invalid BirthDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate dateOfBirth;	
	
	@Email(message="Email Address format not specified")
	@NotNull
	private String emailAddress;
	
	@Length(max=15)
	@NotNull
	private String firstName;
	
	@Length(max=15)
	private String lastName;
	
	@NotNull
	private Id_Type idType;	
	
	@OneToOne
	@JoinColumn(name="address_id")
	private CustomerAddress address;
	
	@OneToOne
	@JoinColumn(name="sim_Id")

	private SimDetails details;
	
	@Pattern(regexp="^[A-Za-z]+$",message="City/State should not contain any special characters except space")
	@NotNull
	private String state;

	public String getUniqueIdNumber() {
		return uniqueIdNumber;
	}

	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Id_Type getIdType() {
		return idType;
	}

	public void setIdType(Id_Type idType) {
		this.idType = idType;
	}

	public CustomerAddress getAddress() {
		return address;
	}

	public void setAddress(CustomerAddress address) {
		this.address = address;
	}

	public SimDetails getDetails() {
		return details;
	}

	public void setDetails(SimDetails details) {
		this.details = details;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Customer(String uniqueIdNumber, @Past(message = "Invalid BirthDate") 
	@NotNull LocalDate dateOfBirth,
			@NotNull @Email(message = "Email Address format not specified") String emailAddress,
			@NotNull @Length(max = 15) String firstName, @Length(max = 15) String lastName, 
			@NotNull Id_Type idType,
			CustomerAddress address, SimDetails details,
			@Pattern(regexp = "^[A-Za-z]+$", message = "City/State should not contain any special characters except space") String state) {
		super();
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
		this.address = address;
		this.details = details;
		this.state = state;
	}

	public Customer() {
		
	}

	@Override
	public String toString() {
		return "Customer [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+ ", address=" + address + ", details=" + details + ", state=" + state + "]";
	}
	
	
	
}
