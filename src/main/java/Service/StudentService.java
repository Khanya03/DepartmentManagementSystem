package Service;

import Domain.Student;
import Repository.StudentRepository;
import Util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create(Student student) {
        if (student == null) return null;
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
        return repository.save(student);
    }

    public Student read(int id) {
        return repository.findById(id).orElse(null);
    }

    public Student update(Student student) {
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

    public List<Student> getAll() {
        return repository.findAll();
    }
}