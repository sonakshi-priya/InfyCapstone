package com.simactivation.Controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simactivation.DTO.CustomerIdentityDTO;
import com.simactivation.Service.CustomerIdentityService;

@RestController
@RequestMapping("/customeridentity")
public class CustomerIdentityController {
	
	
	@Autowired
	private CustomerIdentityService identityService;
	
	
	
//	public CustomerIdentityService getIdentityService() {
//		return identityService;
//	}
//
//
//
//	public void setIdentityService(CustomerIdentityService identityService) {
//		this.identityService = identityService;
//	}



	@PostMapping("/add")
	public ResponseEntity<Object> addCustomer(@RequestBody @Valid CustomerIdentityDTO dto) throws Exception{
		
		
		identityService.add(dto);
		HashMap<String,Object> hm= new HashMap<>();
		hm.put("success","true");
		hm.put("data",null);
		
		return ResponseEntity.ok(hm);
	
		
	}

}
