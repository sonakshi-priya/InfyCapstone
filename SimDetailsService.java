package com.simactivation.Service;

import java.util.List;

import com.simactivation.DTO.SimDetailsDTO;
import com.simactivation.Entity.SimOffers;
import com.simactivation.Exception.SimCardNotValidatedException;

public interface SimDetailsService {

	
	public void insertRecord(SimDetailsDTO dto) throws Exception;
	public List<SimOffers> getOffersByValidation(SimDetailsDTO dto) throws SimCardNotValidatedException;
	public Boolean validateSimDetails(SimDetailsDTO dto);
	
}
