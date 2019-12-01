package fr.univparis8.iut.csid.employee;

import java.util.Objects;

public class Employee {

    private final Long id;

    private final String firstName;

    private final String lastName;

    public Employee(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee mergeWith(Employee other) {
        return EmployeeBuilder.create()
                .withId(id)
                .withLastName(Objects.requireNonNullElse(other.lastName, lastName))
                .withFirstName(Objects.requireNonNullElse(other.firstName, firstName))
                .build();
    }

    public static final class EmployeeBuilder {
        private Long id;
        private String firstName;
        private String lastName;

        private EmployeeBuilder() {
        }

        public static EmployeeBuilder create() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Employee build() {
            return new Employee(id, firstName, lastName);
        }
    }
}
