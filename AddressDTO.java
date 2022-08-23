package com.simactivation.DTO;

import javax.persistence.OneToOne;
// import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simactivation.Entity.Customer;
import com.simactivation.Entity.CustomerAddress;

public class AddressDTO {

	private Integer addId;
	
	@Length(max=25,message="Address should be maximum of 25 characters")
	private String address;	
	
	@Pattern(regexp="^[A-Za-z]+$",message="City/State should not contain any special characters except space")
	private String city;
	
	@Min(100000)
	@Max(999999)
	private Integer pincode;
	
	@Pattern(regexp="^[A-Za-z]+$",message="City/State should not contain any special characters except space")
	private String state;
	
	@OneToOne(mappedBy="address")
	@JsonIgnore
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AddressDTO(@Length(max = 25, message = "Address should be maximum of 25 characters") String address,
			@Pattern(regexp = "^[A-Za-z]+$", message = "City/State should not contain any special characters except space") String city,
			@Min(100000)
			@Max(999999) Integer pincode,
			@Pattern(regexp = "^[A-Za-z]+$", message = "City/State should not contain any special characters except space") String state) {
		super();
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	public AddressDTO(){
		
	}
	
	@Override
	public String toString() {
		return "CustomerAddress [addId=" + addId + ", address=" + address + ", city=" + city + ", pincode=" + pincode
				+ ", state=" + state + "]";
	}
	public Integer getAddId() {
		return addId;
	}
	public void setAddId(Integer addId) {
		this.addId = addId;
	}
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
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
 
	public static CustomerAddress convertDTOToEntity(AddressDTO dto) {
		
		CustomerAddress address = new CustomerAddress();
		
		address.setAddress(dto.getAddress());
		address.setCity(dto.getCity());
		address.setPincode(dto.getPincode());
		address.setState(dto.getState());
		
		return address;
	
		
	}
}
