package Controller;

import Domain.*;
import Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final StudentService studentService;
    private final ProfessorService professorService;
    private final GraduateStudentService graduateStudentService;
    private final AdjunctProfessorService adjunctProfessorService;
    private final PersonService personService;

    @Autowired
    public DepartmentController(DepartmentService departmentService,
                                StudentService studentService,
                                ProfessorService professorService,
                                GraduateStudentService graduateStudentService,
                                AdjunctProfessorService adjunctProfessorService,
                                PersonService personService) {
        this.departmentService = departmentService;
        this.studentService = studentService;
        this.professorService = professorService;
        this.graduateStudentService = graduateStudentService;
        this.adjunctProfessorService = adjunctProfessorService;
        this.personService = personService;
    }

    // ==================== Department Endpoints ====================
    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @GetMapping("/read/{id}")
    public Department readDepartment(@PathVariable int id) {
        return departmentService.read(id);
    }

    @PutMapping("/update")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.update(department);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDepartment(@PathVariable int id) {
        return departmentService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Department> getAllDepartments() {
        return departmentService.getAll();
    }

    // ==================== Student Endpoints ====================
    @PostMapping("/students/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/students/{id}")
    public Student readStudent(@PathVariable int id) {
        return studentService.read(id);
    }

    @PutMapping("/students/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/students/delete/{id}")
    public boolean deleteStudent(@PathVariable int id) {
        return studentService.delete(id);
    }

    @GetMapping("/students/all")
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    // ==================== Professor Endpoints ====================
    @PostMapping("/professors/create")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.create(professor);
    }

    @GetMapping("/professors/{id}")
    public Professor readProfessor(@PathVariable int id) {
        return professorService.read(id);
    }

    @PutMapping("/professors/update")
    public Professor updateProfessor(@RequestBody Professor professor) {
        return professorService.update(professor);
    }

    @DeleteMapping("/professors/delete/{id}")
    public boolean deleteProfessor(@PathVariable int id) {
        return professorService.delete(id);
    }

    @GetMapping("/professors/all")
    public List<Professor> getAllProfessors() {
        return professorService.getAll();
    }

    // ==================== GraduateStudent Endpoints ====================
    @PostMapping("/graduatestudents/create")
    public GraduateStudent createGraduateStudent(@RequestBody GraduateStudent student) {
        return graduateStudentService.create(student);
    }

    @GetMapping("/graduatestudents/{id}")
    public GraduateStudent readGraduateStudent(@PathVariable int id) {
        return graduateStudentService.read(id);
    }

    @PutMapping("/graduatestudents/update")
    public GraduateStudent updateGraduateStudent(@RequestBody GraduateStudent student) {
        return graduateStudentService.update(student);
    }

    @DeleteMapping("/graduatestudents/delete/{id}")
    public boolean deleteGraduateStudent(@PathVariable int id) {
        return graduateStudentService.delete(id);
    }

    @GetMapping("/graduatestudents/all")
    public List<GraduateStudent> getAllGraduateStudents() {
        return graduateStudentService.getAll();
    }

    // ==================== AdjunctProfessor Endpoints ====================
    @PostMapping("/adjunctprofessors/create")
    public AdjunctProfessor createAdjunctProfessor(@RequestBody AdjunctProfessor professor) {
        return adjunctProfessorService.create(professor);
    }

    @GetMapping("/adjunctprofessors/{id}")
    public AdjunctProfessor readAdjunctProfessor(@PathVariable int id) {
        return adjunctProfessorService.read(id);
    }

    @PutMapping("/adjunctprofessors/update")
    public AdjunctProfessor updateAdjunctProfessor(@RequestBody AdjunctProfessor professor) {
        return adjunctProfessorService.update(professor);
    }

    @DeleteMapping("/adjunctprofessors/delete/{id}")
    public boolean deleteAdjunctProfessor(@PathVariable int id) {
        return adjunctProfessorService.delete(id);
    }

    @GetMapping("/adjunctprofessors/all")
    public List<AdjunctProfessor> getAllAdjunctProfessors() {
        return adjunctProfessorService.getAll();
    }

    // ==================== Person Endpoints (for all people) ====================
    @GetMapping("/persons/{id}")
    public Person readPerson(@PathVariable int id) {
        return personService.read(id);
    }

    @DeleteMapping("/persons/delete/{id}")
    public boolean deletePerson(@PathVariable int id) {
        return personService.delete(id);
    }

    @GetMapping("/persons/all")
    public List<Person> getAllPersons() {
        return personService.getAll();
    }
}