package Service;

import Domain.Professor;
import Repository.ProfessorRepository;
import Util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    @Autowired
    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public Professor create(Professor professor) {
        if (professor == null) return null;
        if (Helper.isNullOrEmpty(professor.getFirstName()) || Helper.isNullOrEmpty(professor.getLastName()))
            return null;
        if (Helper.isNullOrEmpty(professor.getEmail()) || !Helper.isValidEmail(professor.getEmail()))
            return null;
        if (Helper.isNullOrEmpty(professor.getPhoneNumber()) || !Helper.isValidPhone(professor.getPhoneNumber()))
            return null;
        if (Helper.isNullOrEmpty(professor.getEmployeeId()) || Helper.isNullOrEmpty(professor.getOfficeNumber()))
            return null;
        return repository.save(professor);
    }

    public Professor read(int id) {
        return repository.findById(id).orElse(null);
    }

    public Professor update(Professor professor) {
        if (professor == null || professor.getId() <= 0) return null;
        return repository.save(professor);
    }

    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Professor> getAll() {
        return repository.findAll();
    }
}