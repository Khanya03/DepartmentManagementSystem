package repository;

import Domain.Department;
import Factory.DepartmentFactory;
import Repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.departmentmanagementsystem.DepartmentManagementSystemApplication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DepartmentManagementSystemApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional   // rolls back changes after each test
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    // No static fields – each test creates its own fresh department

    @Test
    @Order(1)
    void save() {
        Department department = DepartmentFactory.createDepartment("Computer Science", 500000);
        Department saved = repository.save(department);
        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
        System.out.println(saved);
    }

    @Test
    @Order(2)
    void findById() {
        Department department = DepartmentFactory.createDepartment("Mathematics", 300000);
        Department saved = repository.save(department);
        Department found = repository.findById(saved.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("Mathematics", found.getName().getName());
    }

    @Test
    @Order(3)
    void update() {
        Department department = DepartmentFactory.createDepartment("Physics", 400000);
        Department saved = repository.save(department);
        // Use builder copy to create updated version with new budget
        Department updatedEntity = Department.Builder.copy(saved).setBudget(450000).build();
        Department updated = repository.save(updatedEntity);
        assertEquals(450000, updated.getBudget());
    }

    @Test
    @Order(4)
    void delete() {
        Department department = DepartmentFactory.createDepartment("Chemistry", 200000);
        Department saved = repository.save(department);
        int id = saved.getId();
        repository.deleteById(id);
        assertFalse(repository.existsById(id));
    }

    @Test
    @Order(5)
    void findAll() {
        Department department = DepartmentFactory.createDepartment("Biology", 150000);
        repository.save(department);
        assertFalse(repository.findAll().isEmpty());
    }
}