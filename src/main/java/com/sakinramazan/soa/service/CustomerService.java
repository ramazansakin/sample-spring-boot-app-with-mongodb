package com.sakinramazan.soa.service;

import com.sakinramazan.soa.document.Customer;

import java.util.List;

public interface CustomerService {

    Customer create(final Customer customer);

    Customer findById(final String customerId);

    List<Customer> findAll();

    Customer update(Customer customer);

    void delete(final String customerId);

}
