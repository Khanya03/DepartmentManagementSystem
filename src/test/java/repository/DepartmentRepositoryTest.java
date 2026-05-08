package repository;

import Domain.Department;
import Factory.DepartmentFactory;
import Repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    private static Department department;

    @BeforeAll
    static void setUp() {
        department = DepartmentFactory.createDepartment("Computer Science", 500000);
    }

    @Test
    @Order(1)
    void save() {
        Department saved = repository.save(department);
        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
        System.out.println(saved);
    }

    @Test
    @Order(2)
    void findById() {
        Department saved = repository.save(department);
        Department found = repository.findById(saved.getId()).orElse(null);
        assertNotNull(found);
        // getName() returns CourseName — call .getName() to get the String value
        assertEquals("Computer Science", found.getName().getName());
    }

    @Test
    @Order(3)
    void update() {
        Department saved = repository.save(department);
        // Department is immutable — use Builder.copy() to create an updated version
        Department updated = repository.save(
                Department.Builder.copy(saved).setBudget(600000).build()
        );
        assertEquals(600000, updated.getBudget());
    }

    @Test
    @Order(4)
    void delete() {
        Department saved = repository.save(department);
        repository.deleteById(saved.getId());
        assertFalse(repository.existsById(saved.getId()));
    }

    @Test
    @Order(5)
    void findAll() {
        repository.save(department);
        assertFalse(repository.findAll().isEmpty());
    }
}