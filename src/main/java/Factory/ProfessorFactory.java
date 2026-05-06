package Factory;

import Domain.Professor;
import Util.Helper;

public class ProfessorFactory {

    public static Professor createProfessor(String firstName, String lastName, String email, String phoneNumber,
                                            String employeeId, String officeNumber, boolean tenured) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(employeeId) || Helper.isNullOrEmpty(officeNumber)) {
            return null;
        }
        if (!Helper.isValidEmail(email)) return null;
        if (!Helper.isValidPhone(phoneNumber)) return null;

        return new Professor.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setEmployeeId(employeeId)
                .setOfficeNumber(officeNumber)
                .setTenured(tenured)
                .build();
    }
}
