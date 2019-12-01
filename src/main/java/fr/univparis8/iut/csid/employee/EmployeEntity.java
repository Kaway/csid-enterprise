package fr.univparis8.iut.csid.employee;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class EmployeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public EmployeEntity() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeEntity)) return false;
        EmployeEntity that = (EmployeEntity) o;
        return Objects.equals(id, that.id) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    public static final class EmployeEntityBuilder {
        private Long id;
        private String firstName;
        private String lastName;

        private EmployeEntityBuilder() {
        }

        public static EmployeEntityBuilder create() {
            return new EmployeEntityBuilder();
        }

        public EmployeEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeEntityBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeEntityBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeEntity build() {
            EmployeEntity employeEntity = new EmployeEntity();
            employeEntity.setId(id);
            employeEntity.setFirstName(firstName);
            employeEntity.setLastName(lastName);
            return employeEntity;
        }
    }
}
