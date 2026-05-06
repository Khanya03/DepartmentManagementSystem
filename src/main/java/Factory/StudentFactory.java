package Factory;

import Domain.Student;
import Util.Helper;

public class StudentFactory {

    public static Student createStudent(String firstName, String lastName, String email, String phoneNumber,
                                        String studentId, int enrollmentYear, String major) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(studentId) || Helper.isNullOrEmpty(major)) {
            return null;
        }
        if (!Helper.isValidEmail(email)) return null;
        if (!Helper.isValidPhone(phoneNumber)) return null;
        if (enrollmentYear < 1900 || enrollmentYear > 2100) return null;

        return new Student.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setStudentId(studentId)
                .setEnrollmentYear(enrollmentYear)
                .setMajor(major)
                .build();
    }
}