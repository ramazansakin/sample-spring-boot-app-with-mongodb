package com.sakinramazan.soa.service.implementations;

import com.sakinramazan.soa.document.Customer;
import com.sakinramazan.soa.repository.CustomerRepository;
import com.sakinramazan.soa.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Customer : create");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(String customerId) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Customer : findById");
        }
        return customerRepository.findByIdCustomer(customerId);
    }

    @Override
    public List<Customer> findAll() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Customer : findAll");
        }
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Customer : update");
        }
        return customerRepository.save(customer);
    }

    @Override
    public void delete(String customerId) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Customer : delete");
        }
        customerRepository.delete(customerId);
        ;
    }
}
