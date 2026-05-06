package Factory;

import Domain.Department;
import Util.Helper;

public class DepartmentFactory {

    public static Department createDepartment(String name, double budget) {
        if (Helper.isNullOrEmpty(name)) return null;
        if (budget < 0) return null;

        String code = Helper.generateDepartmentCode(name);
        if (code == null) return null;

        return new Department.Builder()
                .setName(name)
                .setCode(code)
                .setBudget(budget)
                .build();
    }
}
