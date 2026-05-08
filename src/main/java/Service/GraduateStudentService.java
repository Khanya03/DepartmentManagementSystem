package Service;

import Domain.GraduateStudent;
import Repository.GraduateStudentRepository;
import Util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GraduateStudentService {

    private final GraduateStudentRepository repository;

    @Autowired
    public GraduateStudentService(GraduateStudentRepository repository) {
        this.repository = repository;
    }

    public GraduateStudent create(GraduateStudent student) {
        if (student == null) return null;
        // reuse student validation (or duplicate minimal checks)
        if (Helper.isNullOrEmpty(student.getFirstName()) || Helper.isNullOrEmpty(student.getLastName()))
            return null;
        if (Helper.isNullOrEmpty(student.getEmail()) || !Helper.isValidEmail(student.getEmail()))
            return null;
        if (Helper.isNullOrEmpty(student.getPhoneNumber()) || !Helper.isValidPhone(student.getPhoneNumber()))
            return null;
        if (Helper.isNullOrEmpty(student.getStudentId()) || Helper.isNullOrEmpty(student.getMajor()))
            return null;
        if (student.getEnrollmentYear() < 1900 || student.getEnrollmentYear() > 2100)
            return null;
        if (Helper.isNullOrEmpty(student.getThesisTitle()) || student.getSupervisor() == null)
            return null;
        return repository.save(student);
    }

    public GraduateStudent read(int id) {
        return repository.findById(id).orElse(null);
    }

    public GraduateStudent update(GraduateStudent student) {
        if (student == null || student.getId() <= 0) return null;
        return repository.save(student);
    }

    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<GraduateStudent> getAll() {
        return repository.findAll();
    }
}