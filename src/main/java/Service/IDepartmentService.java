package Service;

import Domain.Department;
import java.util.List;

public interface IDepartmentService {
    Department create(Department department);
    Department read(int id);
    Department update(Department department);
    boolean delete(int id);
    List<Department> getAll();
}