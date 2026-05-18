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
        super(builder);  // calls Professor(Builder) → Person(Builder) — one chain, no duplication
        this.contractEndDate = builder.contractEndDate;
        this.hourlyRate = builder.hourlyRate;
    }

    public LocalDate getContractEndDate() { return contractEndDate; }
    public double getHourlyRate() { return hourlyRate; }

    @Override
    public String toString() {
        return "AdjunctProfessor{id=" + getId() + ", firstName='" + getFirstName() + "', lastName='" + getLastName() +
                "', email='" + getEmail() + "', phoneNumber='" + getPhoneNumber() + "', employeeId='" + getEmployeeId() +
                "', officeNumber='" + getOfficeNumber() + "', tenured=" + isTenured() + ", contractEndDate=" + contractEndDate +
                ", hourlyRate=" + hourlyRate + "}";
    }

    // Extends Professor.Builder — inherits all fields and setters for free
    public static class Builder extends Professor.Builder {
        private LocalDate contractEndDate;
        private double hourlyRate;

        public Builder setContractEndDate(LocalDate contractEndDate) { this.contractEndDate = contractEndDate; return this; }
        public Builder setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; return this; }

        @Override
        public AdjunctProfessor build() { return new AdjunctProfessor(this); }
    }
}