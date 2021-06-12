package one.digitalinnovation.registerapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;


    private String firstName;

    private String lastName;

    private String cpf;

    private String birthDate;

    private List<PhoneDTO> phones;

}
