package Domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "department_name"))
    private CourseName name;

    private String code;
    private double budget;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Person> members = new ArrayList<>();

    protected Department() {}

    private Department(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.code = builder.code;
        this.budget = builder.budget;
        this.members = builder.members;
    }

    // Getters
    public int getId() { return id; }
    public CourseName getName() { return name; }
    public String getCode() { return code; }
    public double getBudget() { return budget; }
    public List<Person> getMembers() { return members; }

    @Override
    public String toString() {
        return "Department{id=" + id + ", code='" + code + "', budget=" + budget + "}";
    }

    // Builder
    public static class Builder {
        private int id;
        private CourseName name;
        private String code;
        private double budget;
        private List<Person> members = new ArrayList<>();

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setName(CourseName name) { this.name = name; return this; }
        public Builder setCode(String code) { this.code = code; return this; }
        public Builder setBudget(double budget) { this.budget = budget; return this; }
        public Builder setMembers(List<Person> members) { this.members = members; return this; }

        public static Builder copy(Department department) {
            Builder builder = new Builder();
            builder.id = department.getId();
            builder.name = department.getName();
            builder.code = department.getCode();
            builder.budget = department.getBudget();
            builder.members = new ArrayList<>(department.getMembers());
            return builder;
        }

        public Department build() {
            return new Department(this);
        }
    }
}