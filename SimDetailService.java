package com.simactivation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.simactivation.DTO.SimDetailsDTO;
import com.simactivation.Entity.SimDetails;
import com.simactivation.Entity.SimOffers;
import com.simactivation.Exception.SimCardNotValidatedException;
import com.simactivation.Repository.SimDetailsRepository;


@Service("SimdetailsService")
public class SimDetailService implements SimDetailsService{

	private SimDetailsRepository simDetailsRepository;
	// private Optional<SimDetails> simDetails;
    @Autowired
	public void setSimDetailsRepository(SimDetailsRepository simDetailsRepository) {
		this.simDetailsRepository = simDetailsRepository;
	}



	@Override
	public void insertRecord(SimDetailsDTO dto) throws Exception {
		
		
//		List<SimDetails> details = simDetailsRepository.findAll();
//		System.out.println("list"+details);

		//check for PAIR VALIDATION
		List<SimDetails> detailsList = simDetailsRepository.checkForPair(dto.getSimNumber(),dto.getServiceNumber());
		
		
		System.out.println("VALUE"+detailsList);
		
		 if(!detailsList.isEmpty()) {
			 
			 throw new Exception("CAN'T ADD AS RECORD ALREADY EXISTS");
		 }
		
			 
			 SimDetails simDetails = SimDetailsDTO.convertDTOToEntity(dto);
			 simDetailsRepository.save(simDetails);
			 
		
		
		
	}


    @Override
	public List<SimOffers> getOffersByValidation(SimDetailsDTO dto) throws SimCardNotValidatedException {
		// TODO Auto-generated method stub

		Optional<SimDetails> optSimCardDetails = simDetailsRepository.checkForBoth(dto.getSimNumber(), dto.getServiceNumber());
		
		
		if(optSimCardDetails.isEmpty() || !optSimCardDetails.get().getSimStatus()) {
			throw new SimCardNotValidatedException("NOT VALID DETAILS");
		}
		
	
		List<SimOffers> offers = optSimCardDetails.get().getOffers();
		
	    return offers;
	    
	}



	@Override
	public Boolean validateSimDetails(SimDetailsDTO dto) {
		
		Optional<SimDetails> simDetails = simDetailsRepository.checkForBoth(dto.getSimNumber(), dto.getServiceNumber());
		// return !simDetails.isEmpty();
		return simDetails.isPresent();
		// if(!simDetails.isEmpty()){
		// 	return true;
		// }
		// return false;
	}

	
	





}
