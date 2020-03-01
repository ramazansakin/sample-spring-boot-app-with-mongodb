package com.sakinramazan.soa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.sakinramazan.soa.document.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.sakinramazan.soa.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerRepoTest {

    @Autowired
    CustomerRepository repository;
    
    Customer sample1, sample2, sample3;

    // create sample test records
    @Before
    public void setUp() {
        // clear all records
        repository.deleteAll();

        sample1 = repository.save(new Customer("Firstname-1", "Lastname-1"));
        sample2 = repository.save(new Customer("Firstname-2", "Lastname-2"));
        sample3 = repository.save(new Customer("Firstname-3", "Lastname-3"));
    }

    @Test
    public void setsIdOnSave() {
        Customer sample1 = repository.save(new Customer("Sample-Firstname", "Lastname"));
        assertThat(sample1.getIdCustomer()).isNotNull();
    }

    @Test
    public void findsByLastName() {
        List<Customer> result = repository.findByLastName("Lastname-2");
        assertThat(result).hasSize(1).extracting("Firstname").contains("Lastname-2");
    }
}
