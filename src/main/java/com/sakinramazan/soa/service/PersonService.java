package com.sakinramazan.soa.service;

import com.sakinramazan.soa.document.Person;

import java.util.List;

public interface PersonService {

    Person create(final Person person);

    Person findById(final String personId);

    List<Person> findAll();

    Person update(Person person);

    void delete(final String personId);

}
