package Service;

import Domain.*;
import java.util.List;

public interface IDepartmentService {
    Department createDepartment(Department department);
    Department readDepartment(int id);
    Department updateDepartment(Department department);
    boolean deleteDepartment(int id);
    List<Department> getAllDepartments();

    Student addStudentToDepartment(int departmentId, Student student);
    Professor addProfessorToDepartment(int departmentId, Professor professor);
    GraduateStudent addGraduateStudentToDepartment(int departmentId, GraduateStudent student);
    AdjunctProfessor addAdjunctProfessorToDepartment(int departmentId, AdjunctProfessor professor);

    List<Person> getAllMembersOfDepartment(int departmentId);
    List<Student> getStudentsByDepartment(int departmentId);
    List<Professor> getProfessorsByDepartment(int departmentId);
}