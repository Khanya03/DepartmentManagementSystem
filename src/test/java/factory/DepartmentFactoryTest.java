package factory;

import Factory.DepartmentFactory;
import Domain.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {

    @Test
    void createDepartment_validInputs_success() {
        Department dept = DepartmentFactory.createDepartment("Mathematics", 300000);
        assertNotNull(dept);
        assertEquals("Mathematics", dept.getName());
        assertEquals("M", dept.getCode());
        assertEquals(300000, dept.getBudget());
    }

    @Test
    void createDepartment_nullName_returnsNull() {
        Department dept = DepartmentFactory.createDepartment(null, 100000);
        assertNull(dept);
    }

    @Test
    void createDepartment_negativeBudget_returnsNull() {
        Department dept = DepartmentFactory.createDepartment("Physics", -500);
        assertNull(dept);
    }
}