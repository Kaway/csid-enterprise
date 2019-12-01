package fr.univparis8.iut.csid.employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> find(Long id) {
        return employeeRepository.findById(id)
                .map(e -> Employee.EmployeeBuilder
                        .create()
                        .withId(e.getId())
                        .withFirstName(e.getFirstName())
                        .withLastName(e.getLastName())
                        .build()
                );
    }

    public Employee create(Employee employee) {
        return EmployeeMapper.toEmployee(employeeRepository.save(EmployeeMapper.toEmployee(employee)));
    }

    public List<EmployeeDto> getAll() {
        List<Employee> employees = EmployeeMapper.toEmployeesList(employeeRepository.findAll());
        return EmployeeMapper.toEmployeesDtoList(employees);
    }
}
