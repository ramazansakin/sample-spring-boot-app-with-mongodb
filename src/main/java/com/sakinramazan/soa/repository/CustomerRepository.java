package com.sakinramazan.soa.repository;

import com.sakinramazan.soa.document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByLastName(String lastName);

    Customer findByIdCustomer(String id);

}