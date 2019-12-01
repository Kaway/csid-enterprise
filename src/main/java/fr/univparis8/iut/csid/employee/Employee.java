package fr.univparis8.iut.csid.employee;

public class Employee {

    private Long id;

    private String firstName;

    private String lastName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
            Employee employee = new Employee();
            employee.id = this.id;
            employee.firstName = this.firstName;
            employee.lastName = this.lastName;
            return employee;
        }
    }
}
