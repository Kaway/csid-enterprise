package fr.univparis8.iut.csid.employee;

public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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


    public static final class EmployeeDtoBuilder {
        private Long id;
        private String firstName;
        private String lastName;

        private EmployeeDtoBuilder() {
        }

        public static EmployeeDtoBuilder create() {
            return new EmployeeDtoBuilder();
        }

        public EmployeeDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeDtoBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeDtoBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeDto build() {
            return new EmployeeDto(id, firstName, lastName);
        }
    }
}
