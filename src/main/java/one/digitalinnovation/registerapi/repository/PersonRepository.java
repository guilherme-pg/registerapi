package one.digitalinnovation.registerapi.repository;

import one.digitalinnovation.registerapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
