package com.sakinramazan.soa.repository;

import com.sakinramazan.soa.document.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByLastName(String lastName);

    Person findByIdPerson(String id);

    List<Person> findByAddress(String address);

}