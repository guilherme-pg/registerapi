package one.digitalinnovation.registerapi.dto.mapper;

import one.digitalinnovation.registerapi.dto.request.PersonDTO;
import one.digitalinnovation.registerapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
