package Controller;

import Domain.*;
import Service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final IDepartmentService service;

    @Autowired
    public DepartmentController(IDepartmentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department) {
        return service.createDepartment(department);
    }

    @GetMapping("/read/{id}")
    public Department readDepartment(@PathVariable int id) {
        return service.readDepartment(id);
    }

    @PutMapping("/update")
    public Department updateDepartment(@RequestBody Department department) {
        return service.updateDepartment(department);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDepartment(@PathVariable int id) {
        return service.deleteDepartment(id);
    }

    @GetMapping("/getAll")
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

    @PostMapping("/{deptId}/students")
    public Student addStudent(@PathVariable int deptId, @RequestBody Student student) {
        return service.addStudentToDepartment(deptId, student);
    }

    @PostMapping("/{deptId}/professors")
    public Professor addProfessor(@PathVariable int deptId, @RequestBody Professor professor) {
        return service.addProfessorToDepartment(deptId, professor);
    }

    @GetMapping("/{deptId}/members")
    public List<Person> getMembers(@PathVariable int deptId) {
        return service.getAllMembersOfDepartment(deptId);
    }

    @GetMapping("/{deptId}/students")
    public List<Student> getStudents(@PathVariable int deptId) {
        return service.getStudentsByDepartment(deptId);
    }

    @GetMapping("/{deptId}/professors")
    public List<Professor> getProfessors(@PathVariable int deptId) {
        return service.getProfessorsByDepartment(deptId);
    }
}