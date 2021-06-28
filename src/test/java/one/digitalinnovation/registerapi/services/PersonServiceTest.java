package one.digitalinnovation.registerapi.services;

import one.digitalinnovation.registerapi.dto.mapper.PersonMapper;
import one.digitalinnovation.registerapi.dto.request.PersonDTO;
import one.digitalinnovation.registerapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.registerapi.entities.Person;
import one.digitalinnovation.registerapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.registerapi.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.registerapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessesMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessesMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
