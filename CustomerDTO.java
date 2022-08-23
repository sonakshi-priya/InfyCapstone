package com.simactivation.DTO;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.simactivation.Entity.Customer;
import com.simactivation.Enum.Id_Type;

public class CustomerDTO {


	@Length(max=16)
	private String uniqueIdNumber;
	
	
	@Past(message="Invalid BirthDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;	
	
	@Email(message="Email Address format not specified")
	private String emailAddress;
	
	@Length(max=15)
    @NotNull
	private String firstName;
	
	@Length(max=15)
	@NotNull
	private String lastName;
	
	@NotNull
	private Id_Type idType;	
	
	@Max(999999)
	@Min(100000)
	private Integer pincode;
	
	
	@Pattern(regexp="^[A-Za-z]+$",message="City/State should not contain any special characters except space")
	private String address;
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Pattern(regexp="^[A-Za-z]+$",message="City/State should not contain any special characters except space")
	private String city;
	
//	@OneToOne
//	@JoinColumn(name="address_id")
//	private CustomerAddress address;
//	
//	@OneToOne
//	@JoinColumn(name="sim_Id")
//	private SimDetails details;
	
	@Pattern(regexp="^[A-Za-z]+$",message="City/State should not contain any special characters except space")
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
//
//	public CustomerAddress getAddress() {
//		return address;
//	}
//
//	public void setAddress(CustomerAddress address) {
//		this.address = address;
//	}
//
//	public SimDetails getDetails() {
//		return details;
//	}
//
//	public void setDetails(SimDetails details) {
//		this.details = details;
//	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public CustomerDTO(String uniqueIdNumber, @Past(message = "Invalid BirthDate")@NotNull LocalDate dateOfBirth,
			@Email(message = "Email Address format not specified")
	           @NotNull String emailAddress,
			@Length(max = 15) String firstName, @Length(max = 15) String lastName, 
			@NotNull Id_Type idType,
			@Pattern(regexp = "[^a-zA-Z\\d\\s:]", message = "City/State should not contain any special characters except space")
	        @NotNull String state) {
		super();
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
//		this.address = address;
//		this.details = details;
		this.state = state;
	}

	public CustomerDTO(){
		
	}

	@Override
	public String toString() {
		return "Customer [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+"state=" + state + "]";
	}
	
	public static Customer convertDTOToEntity(CustomerDTO dto) {
		
		
		Customer customer = new Customer();
		customer.setDateOfBirth(dto.getDateOfBirth());
		customer.setEmailAddress(dto.getEmailAddress());
		customer.setIdType(dto.getIdType());
		customer.setLastName(dto.getLastName());
		customer.setFirstName(dto.getFirstName());
		customer.setState(dto.getState());
		
		customer.setUniqueIdNumber(dto.getUniqueIdNumber());
		
		return customer;
		
		
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
}
