package shortcut.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shortcut.model.Person;
import shortcut.service.PersonService;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/sign-up")
    public void save(@RequestBody Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personService.save(person);
    }
}
