package com.simactivation.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simactivation.Entity.SimDetails;

@Repository("simdetailsRepo")
public interface SimDetailsRepository extends JpaRepository<SimDetails,Integer>{

	
	@Query("select s from SimDetails s where s.simNumber=?1 or  s.serviceNumber=?2")
	public List<SimDetails> checkForPair(String simNumber,String serviceNumber);
	
	@Query("select s from SimDetails s where s.simNumber=?1 and  s.serviceNumber=?2")
	public Optional<SimDetails> checkForBoth(String simNumber,String serviceNumber);
	
	@Query(value="select * from simdetails where sim_status=0",nativeQuery=true)
	public List<SimDetails> findRandomlyAndActivate();

	
	
}
