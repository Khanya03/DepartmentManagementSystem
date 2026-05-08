package Service;

import Domain.Person;
import Repository.PersonRepository;
import Util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    // Person is abstract, but we can still read/delete/find all
    public Person read(int id) {
        return repository.findById(id).orElse(null);
    }

    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Person> getAll() {
        return repository.findAll();
    }
}