package one.digitalinnovation.registerapi.controller;

import one.digitalinnovation.registerapi.dto.MessageResponseDTO;
import one.digitalinnovation.registerapi.entity.Person;
import one.digitalinnovation.registerapi.repository.PersonRepository;
import one.digitalinnovation.registerapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talia")
public class RegisterController {

    private PersonService personService;

    @Autowired
    public RegisterController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
