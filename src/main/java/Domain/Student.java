package Domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person {

    protected String studentId;
    protected int enrollmentYear;
    protected String major;

    protected Student() {}

    private Student(Builder builder) {
        // Set inherited fields directly (protected access)
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.department = builder.department;
        // Set Student fields
        this.studentId = builder.studentId;
        this.enrollmentYear = builder.enrollmentYear;
        this.major = builder.major;
    }

    public String getStudentId() { return studentId; }
    public int getEnrollmentYear() { return enrollmentYear; }
    public String getMajor() { return major; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName +
                "', email='" + email + "', phoneNumber='" + phoneNumber + "', studentId='" + studentId +
                "', enrollmentYear=" + enrollmentYear + ", major='" + major + "'}";
    }

    public static class Builder {
        // All Person fields
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private Department department;
        // Student fields
        private String studentId;
        private int enrollmentYear;
        private String major;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setDepartment(Department department) { this.department = department; return this; }
        public Builder setStudentId(String studentId) { this.studentId = studentId; return this; }
        public Builder setEnrollmentYear(int enrollmentYear) { this.enrollmentYear = enrollmentYear; return this; }
        public Builder setMajor(String major) { this.major = major; return this; }

        public Student build() {
            return new Student(this);
        }
    }
}