package Service;

import Domain.Department;
import Repository.DepartmentRepository;
import Util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository repository;

    @Autowired
    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Department create(Department department) {
        if (department == null || department.getName() == null || Helper.isNullOrEmpty(department.getName().getName()))
            return null;
        if (department.getBudget() < 0) return null;
        return repository.save(department);
    }

    @Override
    public Department read(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Department update(Department department) {
        if (department == null || department.getId() <= 0) return null;
        return repository.save(department);
    }

    @Override
    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }
}