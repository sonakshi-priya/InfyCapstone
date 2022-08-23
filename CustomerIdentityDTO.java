package com.simactivation.DTO;

import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
// import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simactivation.Entity.CustomerIdentity;
// import com.simactivation.Entity.SimDetails;

public class CustomerIdentityDTO {


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
//	
//	@Pattern(regexp="/[^a-zA-Z ]/g",message="City/State should not contain any special characters except space")
	private String state;

	
	
	public CustomerIdentityDTO() {
		//super();
	}

	public CustomerIdentityDTO(String uniqueIdNumber, @Past(message = "Invalid BirthDate") LocalDate dateOfbirth,
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
	public static CustomerIdentity convertDTOToEntity(CustomerIdentityDTO dto) {
		CustomerIdentity cusmDetails = new CustomerIdentity();
		cusmDetails.setUniqueIdNumber(dto.getUniqueIdNumber());
		cusmDetails.setFirstName(dto.getFirstName());
		cusmDetails.setLastName(dto.getLastName());
		cusmDetails.setState(dto.getState());
		cusmDetails.setEmailAddress(dto.getEmailAddress());
		cusmDetails.setDateOfbirth(dto.getDateOfbirth());
		
		return cusmDetails;
	}
	
}
