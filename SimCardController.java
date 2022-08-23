package com.simactivation.Controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simactivation.DTO.SimDetailsDTO;
import com.simactivation.Entity.SimOffers;
import com.simactivation.Exception.SimCardNotValidatedException;
import com.simactivation.Service.SimDetailService;

@RestController
@RequestMapping("/simcard")
public class SimCardController {

	
	private SimDetailService simCardservice;
	

    @Autowired
	public void setSimCardservice(SimDetailService simCardservice) {
		this.simCardservice = simCardservice;
	}

	@PostMapping("/validatesimcarddetails")
	public ResponseEntity<Object> validate(@RequestBody @Valid SimDetailsDTO simdetailsdto){
		
		Boolean isSimDetailsValid = simCardservice.validateSimDetails(simdetailsdto);
		
		//if no errors related to validation then
		if(isSimDetailsValid){
			return ResponseEntity.ok().body("VALID DETAILS");
		}
		return ResponseEntity.ok().body("Invalid Details");
		
	}
	
	@PostMapping("/addnewcarddetails")
	public ResponseEntity<Object> add(@RequestBody @Valid SimDetailsDTO simdetailsdto) throws Exception{
		
		
		simCardservice.insertRecord(simdetailsdto);
		
		HashMap<String,Object> hm= new HashMap<>();
		hm.put("data","success");
//		{
//			"data":"success"
//		}
		return ResponseEntity.ok(hm);
		
	}
	
	
	
	@PostMapping("/simcardvalidationcustomer")
	public ResponseEntity<Object> validateAndGetOffers(@RequestBody @Valid SimDetailsDTO dto) throws SimCardNotValidatedException{
		
		
		List<SimOffers> offers = simCardservice.getOffersByValidation(dto);
		HashMap<String,Object> hm= new HashMap<>();
		hm.put("data",offers);
		hm.put("message","SIM already active");
		return ResponseEntity.ok(hm);
		
	}
	
}
