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
        super(builder);  // calls Student(Builder) → Person(Builder) — one chain, no duplication
        this.thesisTitle = builder.thesisTitle;
        this.supervisor = builder.supervisor;
    }

    public String getThesisTitle() { return thesisTitle; }
    public Professor getSupervisor() { return supervisor; }

    @Override
    public String toString() {
        return "GraduateStudent{id=" + getId() + ", firstName='" + getFirstName() + "', lastName='" + getLastName() +
                "', email='" + getEmail() + "', phoneNumber='" + getPhoneNumber() + "', studentId='" + getStudentId() +
                "', enrollmentYear=" + getEnrollmentYear() + ", major='" + getMajor() + "', thesisTitle='" + thesisTitle +
                "', supervisor=" + (supervisor != null ? supervisor.getFirstName() : "null") + "}";
    }

    // Extends Student.Builder — inherits all fields and setters for free
    public static class Builder extends Student.Builder {
        private String thesisTitle;
        private Professor supervisor;

        public Builder setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; return this; }
        public Builder setSupervisor(Professor supervisor) { this.supervisor = supervisor; return this; }

        @Override
        public GraduateStudent build() { return new GraduateStudent(this); }
    }
}