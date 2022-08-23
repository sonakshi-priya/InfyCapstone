package com.simactivation.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.simactivation.Entity.SimDetails;

public class SimDetailsDTO {


	private Integer simId;
	
	@NotNull(message="Service Number canot be null")

	@NotBlank(message="Service Number can not be Empty")
	@Pattern(regexp="\\d{10}",message="Service Number must have 10 Digits")
	@Size(min = 10, max = 10,message="Service NUMBER SHOULD HAVE 10 DIGITS")
	private String serviceNumber;
	
	@NotNull(message="SIM NUMBER canot be null")

    @Pattern(regexp="\\d{13}",message="SIM NUMBER must have 13 Digits")
	@Size(min = 13, max = 13,message="SIM NUMBER SHOULD HAVE 13 DIGITS")
	private String simNumber;
	

	private boolean simStatus;
	


	
	
//
//	public Set<SimOffers> getOffers() {
//		return offers;
//	}
//
//
//	public void setOffers(Set<SimOffers> offers) {
//		this.offers = offers;
//	}


	public SimDetailsDTO(
			@NotNull(message = "Service Number canot be null") @NotBlank(message = "Service Number can not be Empty") @Pattern(regexp = "\\d{10}", message = "Service Number must have 10 Digits") @Size(min = 10, max = 10, message = "Service NUMBER SHOULD HAVE 10 DIGITS") String serviceNumber,
			@NotNull(message = "SIM NUMBER canot be null") @Pattern(regexp = "\\d{13}", message = "SIM NUMBER must have 13 Digits") @Size(min = 13, max = 13, message = "SIM NUMBER SHOULD HAVE 13 DIGITS") String simNumber,
			Boolean simStatus) {
		super();
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
	}

	public SimDetailsDTO(){
		
	}
	@Override
	public String toString() {
		return "SimDetails [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + "]";
	}


	public Integer getSimId() {
		return simId;
	}


	public void setSimId(Integer simId) {
		this.simId = simId;
	}


	public String getServiceNumber() {
		return serviceNumber;
	}


	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}


	public String getSimNumber() {
		return simNumber;
	}


	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}


	public boolean getSimStatus() {
		return simStatus;
	}


	public void setSimStatus(boolean simStatus) {
		this.simStatus = simStatus;
	}
	public static SimDetails convertDTOToEntity(SimDetailsDTO dto) {
		SimDetails simDetails = new SimDetails();
		simDetails.setServiceNumber(dto.getServiceNumber());
		simDetails.setSimNumber(dto.getSimNumber());
		simDetails.setSimStatus(dto.getSimStatus());
		
		return simDetails;
	}
}

