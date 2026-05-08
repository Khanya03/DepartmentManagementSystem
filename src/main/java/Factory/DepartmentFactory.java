package Factory;

import Domain.CourseName;
import Domain.Department;
import Util.Helper;

public class DepartmentFactory {

    public static Department createDepartment(String name, double budget) {
        if (Helper.isNullOrEmpty(name)) return null;
        if (budget < 0) return null;

        String code = Helper.generateDepartmentCode(name);
        if (code == null) return null;

        CourseName courseName = new CourseName(name);

        return new Department.Builder()
                .setName(courseName)
                .setCode(code)
                .setBudget(budget)
                .build();
    }
}