package com.sakinramazan.soa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakinramazan.soa.document.Customer;
import com.sakinramazan.soa.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerServiceTest {

    final String BASE_PATH = "http://localhost:8090/customer";

    @Autowired
    private CustomerRepository repository;

    private ObjectMapper MAPPER = new ObjectMapper();

    private RestTemplate restTemplate;

    // save sample test records
    @Before
    public void setUp() {
        // clear old records
        repository.deleteAll();

        repository.save(new Customer("Firstname-1", "Lastname-1"));
        repository.save(new Customer("Firstname-2", "Lastname-2"));
        repository.save(new Customer("Firstname-3", "Lastname-3"));

        restTemplate = new RestTemplate();
    }

    @Test
    public void testCreateCustomer() throws JsonProcessingException {
        restTemplate.delete(BASE_PATH + "/products");

        Customer customer = new Customer("Firstname-1", "Lastname-1");
        Customer response = restTemplate.postForObject(BASE_PATH, customer, Customer.class);
        Assert.assertEquals("Firstname-1 Lastname-1", response.getFirstName() + " " + response.getLastName());
    }

    @Test
    public void testFindOne() throws IOException {
        String response = restTemplate.getForObject(BASE_PATH + "/findAll", String.class);
        List<Customer> customers = MAPPER.readValue(response, MAPPER.getTypeFactory().constructCollectionType(List.class, Customer.class));
        Customer customer = restTemplate.getForObject(BASE_PATH + "/" + customers.get(1).getIdCustomer(), Customer.class);
        Assert.assertNotNull(customer);
        Assert.assertEquals("Firstname-2", customer.getFirstName());
        Assert.assertEquals("Lastname-2", customer.getLastName());
    }

    @Test
    public void testUpdateCustomer() throws IOException {
        String response = restTemplate.getForObject(BASE_PATH + "/findAll", String.class);
        List<Customer> customers = MAPPER.readValue(response, MAPPER.getTypeFactory().constructCollectionType(List.class, Customer.class));

        Customer customer = restTemplate.getForObject(BASE_PATH + "/" + customers.get(2).getIdCustomer(), Customer.class);
        customer.setFirstName("Firstname-3");
        customer.setLastName("Lastname-3");
        restTemplate.put(BASE_PATH, customer);

        Customer customer2 = restTemplate.getForObject(BASE_PATH + "/" + customers.get(2).getIdCustomer(), Customer.class);
        Assert.assertNotNull(customer2);
        Assert.assertEquals("Firstname-3", customer2.getFirstName());
        Assert.assertEquals("Lastname-3", customer2.getLastName());

    }

}
