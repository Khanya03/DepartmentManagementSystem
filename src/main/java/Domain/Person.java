package Domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "department_id")
    protected Department department;

    protected Person() {}

    protected Person(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.department = builder.department;
    }

    // Getters only (no setters)
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public Department getDepartment() { return department; }

    @Override
    public String toString() {
        return "Person{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName +
                "', email='" + email + "', phoneNumber='" + phoneNumber + "'}";
    }

    public static class Builder {
        protected int id;
        protected String firstName;
        protected String lastName;
        protected String email;
        protected String phoneNumber;
        protected Department department;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setDepartment(Department department) { this.department = department; return this; }

        public Person build() {
            throw new UnsupportedOperationException("Use subclass builder");
        }
    }
}