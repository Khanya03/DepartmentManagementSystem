package Domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("GRADUATE")
public class GraduateStudent extends Student {

    private String thesisTitle;
    @ManyToOne
    private Professor supervisor;

    protected GraduateStudent() {}

    private GraduateStudent(Builder builder) {
        // Set all fields (including those from Person and Student)
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.department = builder.department;
        this.studentId = builder.studentId;
        this.enrollmentYear = builder.enrollmentYear;
        this.major = builder.major;
        this.thesisTitle = builder.thesisTitle;
        this.supervisor = builder.supervisor;
    }

    public String getThesisTitle() { return thesisTitle; }
    public Professor getSupervisor() { return supervisor; }

    @Override
    public String toString() {
        return "GraduateStudent{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName +
                "', email='" + email + "', phoneNumber='" + phoneNumber + "', studentId='" + studentId +
                "', enrollmentYear=" + enrollmentYear + ", major='" + major + "', thesisTitle='" + thesisTitle +
                "', supervisor=" + (supervisor != null ? supervisor.getFirstName() : "null") + "}";
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private Department department;
        private String studentId;
        private int enrollmentYear;
        private String major;
        private String thesisTitle;
        private Professor supervisor;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setDepartment(Department department) { this.department = department; return this; }
        public Builder setStudentId(String studentId) { this.studentId = studentId; return this; }
        public Builder setEnrollmentYear(int enrollmentYear) { this.enrollmentYear = enrollmentYear; return this; }
        public Builder setMajor(String major) { this.major = major; return this; }
        public Builder setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; return this; }
        public Builder setSupervisor(Professor supervisor) { this.supervisor = supervisor; return this; }

        public GraduateStudent build() {
            return new GraduateStudent(this);
        }
    }
}