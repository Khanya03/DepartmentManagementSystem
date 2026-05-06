package Domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PROFESSOR")
public class Professor extends Person {

    private String employeeId;
    private String officeNumber;
    private boolean tenured;

    protected Professor() {}

    private Professor(Builder builder) {
        super();
        setId(builder.id);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setEmail(builder.email);
        setPhoneNumber(builder.phoneNumber);
        // Set Professor-specific fields
        this.employeeId = builder.employeeId;
        this.officeNumber = builder.officeNumber;
        this.tenured = builder.tenured;
    }

    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getOfficeNumber() { return officeNumber; }
    public boolean isTenured() { return tenured; }

    // Setters
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setOfficeNumber(String officeNumber) { this.officeNumber = officeNumber; }
    public void setTenured(boolean tenured) { this.tenured = tenured; }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", officeNumber='" + officeNumber + '\'' +
                ", tenured=" + tenured +
                '}';
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String employeeId;
        private String officeNumber;
        private boolean tenured;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setEmployeeId(String employeeId) { this.employeeId = employeeId; return this; }
        public Builder setOfficeNumber(String officeNumber) { this.officeNumber = officeNumber; return this; }
        public Builder setTenured(boolean tenured) { this.tenured = tenured; return this; }

        public static Builder copy(Professor professor) {
            Builder builder = new Builder();
            builder.id = professor.getId();
            builder.firstName = professor.getFirstName();
            builder.lastName = professor.getLastName();
            builder.email = professor.getEmail();
            builder.phoneNumber = professor.getPhoneNumber();
            builder.employeeId = professor.getEmployeeId();
            builder.officeNumber = professor.getOfficeNumber();
            builder.tenured = professor.isTenured();
            return builder;
        }

        public Professor build() {
            return new Professor(this);
        }
    }
}