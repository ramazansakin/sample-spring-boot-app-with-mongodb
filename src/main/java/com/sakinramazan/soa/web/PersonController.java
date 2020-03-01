package com.sakinramazan.soa.web;

import com.sakinramazan.soa.document.Person;
import com.sakinramazan.soa.service.PersonService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(value = "person")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

	// @ApiOperation annotation is used for describing the functionality of the api on swagger
	@ApiOperation(value = "Find all persons")
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		List<Person> persons = personService.findAll();
		ArrayList<Person> personsReturn = new ArrayList<>();
		for (Person person : persons) {
			String idPerson = person.getIdPerson();
			addHATEOASSupport(person, idPerson);
			personsReturn.add(person);
		}
		return personsReturn;
	}

    @ApiOperation(value = "Find person by ID")
    @RequestMapping(value = "/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person get(@PathVariable(value = "personId") String personId) {
        Person person = personService.findById(personId);
        addHATEOASSupport(person, personId);
        return person;
    }

    @ApiOperation(value = "Create a new person")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        Person createdPerson = personService.create(person);
        String idPerson = createdPerson.getIdPerson();
        addHATEOASSupport(createdPerson, idPerson);
        return createdPerson;
    }

    @ApiOperation(value = "Update an existing person")
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        Person updatedPerson = personService.update(person);
        String idPerson = updatedPerson.getIdPerson();
        addHATEOASSupport(updatedPerson, idPerson);
        return updatedPerson;
    }

    @ApiOperation(value = "Delete person by ID")
    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "personId") String personId) {
        personService.delete(personId);
    }

    private void addHATEOASSupport(Person person, String idPerson) {
        person.add(linkTo(methodOn(PersonController.class).get(idPerson)).withSelfRel());
    }
}
