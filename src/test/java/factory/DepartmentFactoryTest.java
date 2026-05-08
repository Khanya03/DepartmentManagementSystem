package factory;

import Factory.DepartmentFactory;
import Domain.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {

   @Test
   void createDepartment_validInputs_success() {
      Department dept = DepartmentFactory.createDepartment("Mathematics", 30000);
      assertNotNull(dept);
      // getName() returns CourseName, so call .getName() on it to get the String
      assertEquals("Mathematics", dept.getName().getName());
      assertEquals("M", dept.getCode());
      assertEquals(30000, dept.getBudget());
   }

   @Test
   void createDepartment_nullName_returnNull() {
      Department dept = DepartmentFactory.createDepartment(null, 30000);
      assertNull(dept);
   }

   @Test
   void createDepartment_budgetNegative_returnNull() {
      Department dept = DepartmentFactory.createDepartment("Physics", -10000);
      assertNull(dept);
   }
}