package com.simactivation.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class SimOffers {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer offerId;
	private Integer callQty;	
	private Integer cost;	
	private Integer dataQty;	
	
	private Integer duration;	
	@NotNull(message="Offer Name can't be Null")
	private String  offerName;	
	
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="sim_Id", nullable=false)
	 private SimDetails simDetails;

	 public SimOffers() {
		 
	 }
	 
	public SimOffers(Integer callQty, Integer cost, Integer dataQty, Integer duration,
			@NotNull(message = "Offer Name can't be Null") String offerName, SimDetails simDetails) {
		super();
		this.callQty = callQty;
		this.cost = cost;
		this.dataQty = dataQty;
		this.duration = duration;
		this.offerName = offerName;
		this.simDetails = simDetails;
	}

	@Override
	public String toString() {
		return "SimOffers [offerId=" + offerId + ", callQty=" + callQty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerName=" + offerName + ", simDetails=" + simDetails + "]";
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Integer getCallQty() {
		return callQty;
	}

	public void setCallQty(Integer callQty) {
		this.callQty = callQty;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getDataQty() {
		return dataQty;
	}

	public void setDataQty(Integer dataQty) {
		this.dataQty = dataQty;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public SimDetails getSimDetails() {
		return simDetails;
	}

	public void setSimDetails(SimDetails simDetails) {
		this.simDetails = simDetails;
	}
	 
	 
	 
	 
	
	
	
	
}
