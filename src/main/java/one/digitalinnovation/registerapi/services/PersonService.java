package one.digitalinnovation.registerapi.services;

import lombok.AllArgsConstructor;
import one.digitalinnovation.registerapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.registerapi.dto.request.PersonDTO;
import one.digitalinnovation.registerapi.entities.Person;
import one.digitalinnovation.registerapi.exception.PersonNotFoundException;
import one.digitalinnovation.registerapi.dto.mapper.PersonMapper;
import one.digitalinnovation.registerapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        MessageResponseDTO messageResponse = createMessageResponse("Created person with ID ", savedPerson.getId());
        return messageResponse;
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return  personMapper.toDTO(person);
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());
        return messageResponse;
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        personRepository.deleteById(id);
    }



    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String message, Long id2) {
        return MessageResponseDTO
                .builder()
                .message(message + id2)
                .build();
    }
}
