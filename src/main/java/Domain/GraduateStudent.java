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
        super();
        setId(builder.id);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setEmail(builder.email);
        setPhoneNumber(builder.phoneNumber);
        setStudentId(builder.studentId);
        setEnrollmentYear(builder.enrollmentYear);
        setMajor(builder.major);
        this.thesisTitle = builder.thesisTitle;
        this.supervisor = builder.supervisor;
    }

    public String getThesisTitle() { return thesisTitle; }
    public void setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; }
    public Professor getSupervisor() { return supervisor; }
    public void setSupervisor(Professor supervisor) { this.supervisor = supervisor; }

    @Override
    public String toString() {
        return "GraduateStudent{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", studentId='" + getStudentId() + '\'' +
                ", enrollmentYear=" + getEnrollmentYear() +
                ", major='" + getMajor() + '\'' +
                ", thesisTitle='" + thesisTitle + '\'' +
                ", supervisor=" + (supervisor != null ? supervisor.getFirstName() : "null") +
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
        private String thesisTitle;
        private Professor supervisor;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setStudentId(String studentId) { this.studentId = studentId; return this; }
        public Builder setEnrollmentYear(int enrollmentYear) { this.enrollmentYear = enrollmentYear; return this; }
        public Builder setMajor(String major) { this.major = major; return this; }
        public Builder setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; return this; }
        public Builder setSupervisor(Professor supervisor) { this.supervisor = supervisor; return this; }

        public static Builder copy(GraduateStudent gs) {
            Builder builder = new Builder();
            builder.id = gs.getId();
            builder.firstName = gs.getFirstName();
            builder.lastName = gs.getLastName();
            builder.email = gs.getEmail();
            builder.phoneNumber = gs.getPhoneNumber();
            builder.studentId = gs.getStudentId();
            builder.enrollmentYear = gs.getEnrollmentYear();
            builder.major = gs.getMajor();
            builder.thesisTitle = gs.getThesisTitle();
            builder.supervisor = gs.getSupervisor();
            return builder;
        }

        public GraduateStudent build() {
            return new GraduateStudent(this);
        }
    }
}