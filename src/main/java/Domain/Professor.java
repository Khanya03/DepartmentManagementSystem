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

    protected Professor(Builder builder) {
        super(builder);
        this.employeeId = builder.employeeId;
        this.officeNumber = builder.officeNumber;
        this.tenured = builder.tenured;
    }

    public String getEmployeeId() { return employeeId; }
    public String getOfficeNumber() { return officeNumber; }
    public boolean isTenured() { return tenured; }

    @Override
    public String toString() {
        return "Professor{id=" + getId() + ", firstName='" + getFirstName() + "', lastName='" + getLastName() +
                "', email='" + getEmail() + "', phoneNumber='" + getPhoneNumber() + "', employeeId='" + employeeId +
                "', officeNumber='" + officeNumber + "', tenured=" + tenured + "}";
    }

    public static class Builder {
        protected int id;
        protected String firstName;
        protected String lastName;
        protected String email;
        protected String phoneNumber;
        protected Department department;
        protected String employeeId;
        protected String officeNumber;
        protected boolean tenured;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setDepartment(Department department) { this.department = department; return this; }
        public Builder setEmployeeId(String employeeId) { this.employeeId = employeeId; return this; }
        public Builder setOfficeNumber(String officeNumber) { this.officeNumber = officeNumber; return this; }
        public Builder setTenured(boolean tenured) { this.tenured = tenured; return this; }

        public Professor build() { return new Professor(this); }
    }
}