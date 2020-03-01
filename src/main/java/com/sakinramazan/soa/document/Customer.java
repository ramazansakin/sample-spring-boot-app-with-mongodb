package com.sakinramazan.soa.document;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;


public class Customer extends ResourceSupport implements Serializable {

    @Id
    private String idCustomer;

    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer [idCustomer=" + idCustomer + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}