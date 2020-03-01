package com.sakinramazan.soa.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person extends ResourceSupport implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private String idPerson;
    private String firstName;
    private String lastName;
    private String address;
    
    public Person() {}

	public Person(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public String getIdPerson() {
        return idPerson;
    }
    
    public void setIdPerson(String id) {
        this.idPerson = id;
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
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }


	@Override
	public String toString() {
		return "Person [idPerson=" + idPerson + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + "]";
	}
}