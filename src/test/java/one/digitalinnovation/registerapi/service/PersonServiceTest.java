package one.digitalinnovation.registerapi.service;

import one.digitalinnovation.registerapi.dto.MessageResponseDTO;
import one.digitalinnovation.registerapi.dto.request.PersonDTO;
import one.digitalinnovation.registerapi.entities.Person;
import one.digitalinnovation.registerapi.repository.PersonRepository;
import one.digitalinnovation.registerapi.utils.PersonUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.registerapi.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.registerapi.utils.PersonUtils.createFakeEntity;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessesMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

/*   19:34     Assertions.assertEq*/
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
