package shortcut.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shortcut.model.Person;
import shortcut.model.Site;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByLogin(String login);
}
