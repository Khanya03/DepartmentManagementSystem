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

    private Student(Builder builder) {
        // Use no-arg super() then set inherited fields via setters
        super();
        setId(builder.id);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setEmail(builder.email);
        setPhoneNumber(builder.phoneNumber);
        // Set Student-specific fields
        this.studentId = builder.studentId;
        this.enrollmentYear = builder.enrollmentYear;
        this.major = builder.major;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public int getEnrollmentYear() { return enrollmentYear; }
    public String getMajor() { return major; }

    // Setters (if needed for updates)
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setEnrollmentYear(int enrollmentYear) { this.enrollmentYear = enrollmentYear; }
    public void setMajor(String major) { this.major = major; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", studentId='" + studentId + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", major='" + major + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String studentId;
        private int enrollmentYear;
        private String major;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setStudentId(String studentId) { this.studentId = studentId; return this; }
        public Builder setEnrollmentYear(int enrollmentYear) { this.enrollmentYear = enrollmentYear; return this; }
        public Builder setMajor(String major) { this.major = major; return this; }

        public static Builder copy(Student student) {
            Builder builder = new Builder();
            builder.id = student.getId();
            builder.firstName = student.getFirstName();
            builder.lastName = student.getLastName();
            builder.email = student.getEmail();
            builder.phoneNumber = student.getPhoneNumber();
            builder.studentId = student.getStudentId();
            builder.enrollmentYear = student.getEnrollmentYear();
            builder.major = student.getMajor();
            return builder;
        }

        public Student build() {
            return new Student(this);
        }
    }
}