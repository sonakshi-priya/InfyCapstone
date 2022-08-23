package com.simactivation.DTO;


import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerValidateDTO {

	
	
	@Email(message="Email Address format not specified")
	@NotNull
	private String emailAddress;
	
	@Length(max=15)
	@NotBlank(message="firstName Can't be empty")
	@NotNull
	private String firstName;
	
	@Length(max=15)
	@NotBlank(message="LastName Can't be empty")
	@NotNull
	private String lastName;
	
	@Past(message="Invalid BirthDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate dateOfbirth;	


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

	public LocalDate getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(LocalDate dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerValidateDTO(@Email(message = "Email Address format not specified") String emailAddress,
			@Length(max = 15) String firstName, @Length(max = 15) String lastName) {
		super();
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public CustomerValidateDTO() {
		super();
	}

	
}
