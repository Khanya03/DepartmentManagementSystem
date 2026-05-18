package Factory;

import Domain.GraduateStudent;
import Domain.Professor;
import Util.Helper;

public class GraduateStudentFactory {

    public static GraduateStudent createGraduateStudent(String firstName, String lastName, String email, String phoneNumber,
                                                        String studentId, int enrollmentYear, String major,
                                                        String thesisTitle, Professor supervisor) {
        // 1. Validation logic stays exactly the same
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(studentId) || Helper.isNullOrEmpty(major) ||
                Helper.isNullOrEmpty(thesisTitle) || supervisor == null) {
            return null;
        }
        if (!Helper.isValidEmail(email)) return null;
        if (!Helper.isValidPhone(phoneNumber)) return null;
        if (enrollmentYear < 1900 || enrollmentYear > 2100) return null;

        // 2. Fixed Chain Order with explicit casting at the end
        return ((GraduateStudent.Builder) new GraduateStudent.Builder()
                .setThesisTitle(thesisTitle)
                .setSupervisor(supervisor)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setStudentId(studentId)
                .setEnrollmentYear(enrollmentYear)
                .setMajor(major))
                .build();
    }
}