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
        super();
        setId(builder.id);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setEmail(builder.email);
        setPhoneNumber(builder.phoneNumber);
        setEmployeeId(builder.employeeId);
        setOfficeNumber(builder.officeNumber);
        setTenured(builder.tenured);
        this.contractEndDate = builder.contractEndDate;
        this.hourlyRate = builder.hourlyRate;
    }

    public LocalDate getContractEndDate() { return contractEndDate; }
    public void setContractEndDate(LocalDate contractEndDate) { this.contractEndDate = contractEndDate; }
    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    @Override
    public String toString() {
        return "AdjunctProfessor{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", employeeId='" + getEmployeeId() + '\'' +
                ", officeNumber='" + getOfficeNumber() + '\'' +
                ", tenured=" + isTenured() +
                ", contractEndDate=" + contractEndDate +
                ", hourlyRate=" + hourlyRate +
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
        private LocalDate contractEndDate;
        private double hourlyRate;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setEmployeeId(String employeeId) { this.employeeId = employeeId; return this; }
        public Builder setOfficeNumber(String officeNumber) { this.officeNumber = officeNumber; return this; }
        public Builder setTenured(boolean tenured) { this.tenured = tenured; return this; }
        public Builder setContractEndDate(LocalDate contractEndDate) { this.contractEndDate = contractEndDate; return this; }
        public Builder setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; return this; }

        public static Builder copy(AdjunctProfessor adjunct) {
            Builder builder = new Builder();
            builder.id = adjunct.getId();
            builder.firstName = adjunct.getFirstName();
            builder.lastName = adjunct.getLastName();
            builder.email = adjunct.getEmail();
            builder.phoneNumber = adjunct.getPhoneNumber();
            builder.employeeId = adjunct.getEmployeeId();
            builder.officeNumber = adjunct.getOfficeNumber();
            builder.tenured = adjunct.isTenured();
            builder.contractEndDate = adjunct.getContractEndDate();
            builder.hourlyRate = adjunct.getHourlyRate();
            return builder;
        }

        public AdjunctProfessor build() {
            return new AdjunctProfessor(this);
        }
    }
}