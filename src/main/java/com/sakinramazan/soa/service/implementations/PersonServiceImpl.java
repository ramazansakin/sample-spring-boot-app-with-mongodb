package com.sakinramazan.soa.service.implementations;

import com.sakinramazan.soa.document.Person;
import com.sakinramazan.soa.repository.PersonRepository;
import com.sakinramazan.soa.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = Logger.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person create(Person person) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Person : create");
        }
        return personRepository.save(person);
    }

    @Override
    public Person findById(String personId) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Person : findById ");
        }
        return personRepository.findByIdPerson(personId);
    }

    @Override
    public List<Person> findAll() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Person : findAll");
        }
        return personRepository.findAll();
    }

    @Override
    public Person update(Person person) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Person : update");
        }
        return personRepository.save(person);
    }

    @Override
    public void delete(String personId) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("method called - Person : delete");
        }
        personRepository.delete(personId);
    }
}
