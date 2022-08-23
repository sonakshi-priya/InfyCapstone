package com.simactivation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simactivation.Entity.Customer;

@Repository("customerRepositories")
public interface CustomerRepository extends JpaRepository<Customer,String>{

}
