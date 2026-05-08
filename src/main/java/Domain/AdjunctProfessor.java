package Domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("ADJUNCT")
public class AdjunctProfessor extends Professor {

    private LocalDate contractEndDate;
    private double hourlyRate;

    protected AdjunctProfessor() {}

    private AdjunctProfessor(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.department = builder.department;
        this.employeeId = builder.employeeId;
        this.officeNumber = builder.officeNumber;
        this.tenured = builder.tenured;
        this.contractEndDate = builder.contractEndDate;
        this.hourlyRate = builder.hourlyRate;
    }

    public LocalDate getContractEndDate() { return contractEndDate; }
    public double getHourlyRate() { return hourlyRate; }

    @Override
    public String toString() {
        return "AdjunctProfessor{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName +
                "', email='" + email + "', phoneNumber='" + phoneNumber + "', employeeId='" + employeeId +
                "', officeNumber='" + officeNumber + "', tenured=" + tenured + ", contractEndDate=" + contractEndDate +
                ", hourlyRate=" + hourlyRate + "}";
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private Department department;
        private String employeeId;
        private String officeNumber;
        private boolean tenured;
        private LocalDate contractEndDate;
        private double hourlyRate;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setDepartment(Department department) { this.department = department; return this; }
        public Builder setEmployeeId(String employeeId) { this.employeeId = employeeId; return this; }
        public Builder setOfficeNumber(String officeNumber) { this.officeNumber = officeNumber; return this; }
        public Builder setTenured(boolean tenured) { this.tenured = tenured; return this; }
        public Builder setContractEndDate(LocalDate contractEndDate) { this.contractEndDate = contractEndDate; return this; }
        public Builder setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; return this; }

        public AdjunctProfessor build() {
            return new AdjunctProfessor(this);
        }
    }
}