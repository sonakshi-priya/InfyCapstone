package com.simactivation.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simactivation.DTO.CustomerDTO;
import com.simactivation.DTO.CustomerValidateDTO;
import com.simactivation.Entity.Customer;
import com.simactivation.Entity.CustomerAddress;
import com.simactivation.Entity.CustomerIdentity;
import com.simactivation.Entity.SimDetails;
import com.simactivation.Repository.AddressRepository;
import com.simactivation.Repository.CustomerIdentityRepository;
import com.simactivation.Repository.CustomerRepository;
import com.simactivation.Repository.SimDetailsRepository;

@Service("customerservices")
@Transactional
public class CustomerService {

	
	@Autowired
	private CustomerIdentityRepository customerIdentityRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private SimDetailsRepository simDetailsRepo; 
	
	@Autowired
	private AddressRepository addressRepo;
	
	
	
	public String validate(CustomerValidateDTO dto) throws Exception {
		
		
		String firstName = dto.getFirstName();
		String lastName = dto.getLastName();
		
		
		String email = dto.getEmailAddress();
		
		
	   LocalDate date = dto.getDateOfbirth();
	   
		Optional<CustomerIdentity> optCustomerIdentiy = customerIdentityRepo.findByFirstNameLastNameAndEmail(firstName, lastName, email);
		
		if(optCustomerIdentiy.isEmpty()) {
			throw new Exception("Customer Not Available");
		}
		
		if(!optCustomerIdentiy.get().getDateOfbirth().equals(date)) {
			throw new Exception("No request placed for you");
		}

			
		return "VALID";
		
	}
	public static Integer getRandomNumberUsingNextInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
	
	public Object validateIDProofAndActivate(CustomerDTO dto) throws Exception {
		
		
		//check if RECORD EXISTS WITH GIVEN UNIQUE NUMBER
		
		Optional<CustomerIdentity>  customerOptional = customerIdentityRepo.findById(dto.getUniqueIdNumber());
		
		if(customerOptional.isEmpty()) {
			throw new Exception("Invalid details");
		}
		
		CustomerIdentity customerFromRecord = customerOptional.get();
	    
		
		//VERIFICATION PROCESS STARTS FOR NAME
		if(customerFromRecord.getFirstName().toLowerCase().equals(dto.getFirstName().toLowerCase()) 
				
			&& customerFromRecord.getLastName().toLowerCase().equals(dto.getLastName().toLowerCase())
				
			&&	customerFromRecord.getDateOfbirth().equals(dto.getDateOfBirth())) {
			
			
			
			
			//ADDRESS PROOF PROCESS
			
	
			Optional<CustomerAddress> addressOptional = addressRepo.findBypincode(dto.getPincode()); 
			
			CustomerAddress customerAddress;
			
			if(!addressOptional.isPresent()) {
				customerAddress = new CustomerAddress();
				customerAddress.setAddress(dto.getAddress());
				customerAddress.setPincode(dto.getPincode());
				customerAddress.setCity(dto.getCity());
				customerAddress.setState(dto.getState());
			}
			else {
				customerAddress = addressOptional.get();
			}
			//VALID
			// FIND THE SIM WHICH IS AVAILABLE AND CURRENTLY NOT ACTIVE
				
			List<SimDetails> availableSimCards = simDetailsRepo.findRandomlyAndActivate();
			
			//GIVE ONLY THOSE SIM WHICH HAVE OFFERS
			
			List<SimDetails> filterWithAvailableOffers = availableSimCards.stream().filter(
					
					sim-> sim.getOffers().size()>=1
					
					).toList();
			
			
			
			int size = filterWithAvailableOffers.size();
			
			if(size==0) {
				throw new Exception("NO SIMCARD AVAILABLE /OFFERS. CONTACT SERVICE PROVIDER");
			}
			
			int generateRnadomNumberInRange  = CustomerService.getRandomNumberUsingNextInt(0,size);
			
			if(generateRnadomNumberInRange <0) {
				throw new Exception("Out of Range");
			}
		 
			//GET THE SIM NOW FROM THE RANDOM INDEX
			
			SimDetails simToBeAlloted = filterWithAvailableOffers.get(generateRnadomNumberInRange);
			
			
			//ACTIVATE THE SIM
		
			
			simToBeAlloted.setSimStatus(true);
			
			simDetailsRepo.save(simToBeAlloted);
			
			//PREPARE CUSTOMER ENTITY
			Customer customer = CustomerDTO.convertDTOToEntity(dto);
			customer.setDetails(simToBeAlloted);
			
			// ADDRESS PROVIDED
			customer.setAddress(customerAddress);
			
			// CUSTOMER RECORD UPDATE WITH SIM
			
			customerRepo.save(customer);
			
			//CUSTOMER DETAILS UPDATED
			
			HashMap<String,Object> dataObject = new HashMap<>();
			dataObject.put("simActiveStatus",Boolean.TRUE);
			dataObject.put("customerDetails",customer);
			dataObject.put("SimDetails",customer.getDetails());
			dataObject.put("verified_Through",customer.getIdType());
			dataObject.put("SimOffers",customer.getDetails().getOffers());
			dataObject.put("Addressusedforverification", customerAddress);
			dataObject.put("ActivatedOn",LocalDateTime.now());
			
		    return dataObject;
			
		}
		else {
			
			throw new Exception("DETAILS NOT VALID");
		}
		
		
		
		
	}
}
