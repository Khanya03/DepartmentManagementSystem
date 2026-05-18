package Factory;

import Domain.AdjunctProfessor;
import Util.Helper;
import java.time.LocalDate;

public class AdjunctProfessorFactory {

    public static AdjunctProfessor createAdjunctProfessor(String firstName, String lastName, String email, String phoneNumber,
                                                          String employeeId, String officeNumber,
                                                          LocalDate contractEndDate, double hourlyRate) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(employeeId) || Helper.isNullOrEmpty(officeNumber) ||
                contractEndDate == null || hourlyRate <= 0) {
            return null;
        }
        if (!Helper.isValidEmail(email)) return null;
        if (!Helper.isValidPhone(phoneNumber)) return null;
        if (contractEndDate.isBefore(LocalDate.now())) return null;

        return ((AdjunctProfessor.Builder) new AdjunctProfessor.Builder()
                .setContractEndDate(contractEndDate)
                .setHourlyRate(hourlyRate)
                .setTenured(false)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setEmployeeId(employeeId)
                .setOfficeNumber(officeNumber))
                .build();
    }
}