package com.simactivation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simactivation.Entity.CustomerIdentity;

@Repository("customeridentityrepo")
public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity,String> {

	
	@Query("select c from CustomerIdentity c where c.firstName=?1 and c.lastName=?2 and c.emailAddress=?3")
	public Optional<CustomerIdentity> findByFirstNameLastNameAndEmail(String firstName,String lastName,String email);
	
}
