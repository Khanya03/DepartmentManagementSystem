package Service;

import Domain.*;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final PersonRepository personRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final GraduateStudentRepository graduateStudentRepository;
    private final AdjunctProfessorRepository adjunctProfessorRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository,
                             PersonRepository personRepository,
                             StudentRepository studentRepository,
                             ProfessorRepository professorRepository,
                             GraduateStudentRepository graduateStudentRepository,
                             AdjunctProfessorRepository adjunctProfessorRepository) {
        this.departmentRepository = departmentRepository;
        this.personRepository = personRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.graduateStudentRepository = graduateStudentRepository;
        this.adjunctProfessorRepository = adjunctProfessorRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department readDepartment(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public boolean deleteDepartment(int id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Student addStudentToDepartment(int departmentId, Student student) {
        Department dept = readDepartment(departmentId);
        if (dept == null) return null;
        return studentRepository.save(student);
    }

    @Override
    public Professor addProfessorToDepartment(int departmentId, Professor professor) {
        Department dept = readDepartment(departmentId);
        if (dept == null) return null;
        return professorRepository.save(professor);
    }

    @Override
    public GraduateStudent addGraduateStudentToDepartment(int departmentId, GraduateStudent student) {
        Department dept = readDepartment(departmentId);
        if (dept == null) return null;
        return graduateStudentRepository.save(student);
    }

    @Override
    public AdjunctProfessor addAdjunctProfessorToDepartment(int departmentId, AdjunctProfessor professor) {
        Department dept = readDepartment(departmentId);
        if (dept == null) return null;
        return adjunctProfessorRepository.save(professor);
    }

    @Override
    public List<Person> getAllMembersOfDepartment(int departmentId) {
        return personRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByDepartment(int departmentId) {
        return studentRepository.findAll();
    }

    @Override
    public List<Professor> getProfessorsByDepartment(int departmentId) {
        return professorRepository.findAll();
    }
}