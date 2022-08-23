package com.simactivation.Service;

//  import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simactivation.DTO.CustomerIdentityDTO;
import com.simactivation.Entity.CustomerIdentity;
import com.simactivation.Repository.CustomerIdentityRepository;

@Service("customerIdentityService")
public class CustomerIdentityService {
     
	private CustomerIdentityRepository identityRepo;
	
	

	@Autowired
	public void setIdentityRepo(CustomerIdentityRepository identityRepo) {
		this.identityRepo = identityRepo;
	}

	
	
	public void add(CustomerIdentityDTO dto) throws Exception{
	
		System.out.println(dto.getUniqueIdNumber()+"   "+identityRepo.existsById(dto.getUniqueIdNumber()));
	
		
//		Optional<CustomerIdentity> optIdentity = identityRepo.findById(dto.getUniqueIdNumber());
//		System.out.println("Optional check"+optIdentity.get());
		if(identityRepo.existsById(dto.getUniqueIdNumber())) {
			throw new Exception("Customer is already present");
		}
		CustomerIdentity identityEntity = CustomerIdentityDTO.convertDTOToEntity(dto);
		identityRepo.save(identityEntity);
		
	}
}
