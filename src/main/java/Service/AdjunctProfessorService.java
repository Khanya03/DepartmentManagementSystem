package Service;

import Domain.AdjunctProfessor;
import Repository.AdjunctProfessorRepository;
import Util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AdjunctProfessorService {

    private final AdjunctProfessorRepository repository;

    @Autowired
    public AdjunctProfessorService(AdjunctProfessorRepository repository) {
        this.repository = repository;
    }

    public AdjunctProfessor create(AdjunctProfessor professor) {
        if (professor == null) return null;
        if (Helper.isNullOrEmpty(professor.getFirstName()) || Helper.isNullOrEmpty(professor.getLastName()))
            return null;
        if (Helper.isNullOrEmpty(professor.getEmail()) || !Helper.isValidEmail(professor.getEmail()))
            return null;
        if (Helper.isNullOrEmpty(professor.getPhoneNumber()) || !Helper.isValidPhone(professor.getPhoneNumber()))
            return null;
        if (Helper.isNullOrEmpty(professor.getEmployeeId()) || Helper.isNullOrEmpty(professor.getOfficeNumber()))
            return null;
        if (professor.getContractEndDate() == null || professor.getContractEndDate().isBefore(LocalDate.now()))
            return null;
        if (professor.getHourlyRate() <= 0) return null;
        return repository.save(professor);
    }

    public AdjunctProfessor read(int id) {
        return repository.findById(id).orElse(null);
    }

    public AdjunctProfessor update(AdjunctProfessor professor) {
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

    public List<AdjunctProfessor> getAll() {
        return repository.findAll();
    }
}