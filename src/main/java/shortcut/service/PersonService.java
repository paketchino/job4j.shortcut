package shortcut.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shortcut.model.Person;
import shortcut.repostitory.PersonRepository;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public void save(Person person) {
        personRepository.save(person);
    }
}
