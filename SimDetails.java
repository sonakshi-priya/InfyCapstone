package com.simactivation.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="simdetails")
@JsonIgnoreProperties(value={"offers"})
public class SimDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sim_Id")
	private Integer simId;
	
	@NotNull(message="Service Number canot be null")
	@Column(unique=true)
	@NotBlank(message="Service Number can not be Empty")
	@Pattern(regexp="\\d{10}",message="Service Number must have 10 Digits")
	@Size(min = 10, max = 10,message="Service NUMBER SHOULD HAVE 10 DIGITS")
	private String serviceNumber;
	
	@NotNull(message="SIM NUMBER canot be null")
	@Column(unique=true)
    @Pattern(regexp="\\d{13}",message="SIM NUMBER must have 13 Digits")
	@Size(min = 13, max = 13,message="SIM NUMBER SHOULD HAVE 13 DIGITS")
	private String simNumber;
	
	private boolean simStatus;
	

    @OneToMany(mappedBy="simDetails")
	private List<SimOffers> offers;
	

	


	public List<SimOffers> getOffers() {
		return offers;
	}




	public void setOffers(List<SimOffers> offers) {
		this.offers = offers;
	}




	public SimDetails(
			@NotNull(message = "Service Number canot be null") @NotBlank(message = "Service Number can not be Empty") @Pattern(regexp = "\\d{10}", message = "Service Number must have 10 Digits") @Size(min = 10, max = 10, message = "Service NUMBER SHOULD HAVE 10 DIGITS") String serviceNumber,
			@NotNull(message = "SIM NUMBER canot be null") @Pattern(regexp = "\\d{13}", message = "SIM NUMBER must have 13 Digits") @Size(min = 13, max = 13, message = "SIM NUMBER SHOULD HAVE 13 DIGITS") String simNumber,
			boolean simStatus) {
		super();
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
	}




	public SimDetails() {
		// TODO Auto-generated constructor stub
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
	
}
