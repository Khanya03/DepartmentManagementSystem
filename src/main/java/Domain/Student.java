package Domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person {

    private String studentId;
    private int enrollmentYear;
    private String major;

    protected Student() {}

    protected Student(Builder builder) {
        super(builder);
        this.studentId = builder.studentId;
        this.enrollmentYear = builder.enrollmentYear;
        this.major = builder.major;
    }

    public String getStudentId() { return studentId; }
    public int getEnrollmentYear() { return enrollmentYear; }
    public String getMajor() { return major; }

    @Override
    public String toString() {
        return "Student{id=" + getId() + ", firstName='" + getFirstName() + "', lastName='" + getLastName() +
                "', email='" + getEmail() + "', phoneNumber='" + getPhoneNumber() + "', studentId='" + studentId +
                "', enrollmentYear=" + enrollmentYear + ", major='" + major + "'}";
    }

    public static class Builder {
        protected int id;
        protected String firstName;
        protected String lastName;
        protected String email;
        protected String phoneNumber;
        protected Department department;
        protected String studentId;
        protected int enrollmentYear;
        protected String major;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setDepartment(Department department) { this.department = department; return this; }
        public Builder setStudentId(String studentId) { this.studentId = studentId; return this; }
        public Builder setEnrollmentYear(int enrollmentYear) { this.enrollmentYear = enrollmentYear; return this; }
        public Builder setMajor(String major) { this.major = major; return this; }

        public Student build() { return new Student(this); }
    }
}