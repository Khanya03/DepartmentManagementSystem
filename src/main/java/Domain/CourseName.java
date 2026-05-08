package Domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class CourseName {
    private String name;

    protected CourseName() {}  // for JPA

    public CourseName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }
}
