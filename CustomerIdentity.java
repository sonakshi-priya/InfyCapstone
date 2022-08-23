package com.simactivation.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
// import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CustomerIdentity {

	
	@Id
	@Length(max=16)
	private String uniqueIdNumber;	
	
	@Past(message="Invalid BirthDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfbirth;	
	
	@Length(max=15)
	private String firstName;
	@Length(max=15)
	private String lastName;
	@Email(message="Email Address format not specified")
	private String emailAddress;	
	
//	@Pattern(regexp="/[^a-zA-Z ]/g",message="City/State should not contain any special characters except space")
	private String state;

	
	
	public CustomerIdentity() {
		super();
	}

	public CustomerIdentity(String uniqueIdNumber, @Past(message = "Invalid BirthDate") LocalDate dateOfbirth,
			@Length(max = 15) String firstName, @Length(max = 15) String lastName,
			@Email(message = "Email Address format not specified") String emailAddress,
			 String state) {
		super();
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfbirth = dateOfbirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.state = state;
	}

	@Override
	public String toString() {
		return "CustomerIdentity [uniqueIdNumber=" + uniqueIdNumber + ", dateOfbirth=" + dateOfbirth + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", state=" + state + "]";
	}

	public String getUniqueIdNumber() {
		return uniqueIdNumber;
	}

	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}

	public LocalDate getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(LocalDate dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
