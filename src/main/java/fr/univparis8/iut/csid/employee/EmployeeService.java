package fr.univparis8.iut.csid.employee;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee get(Long id) {
        return EmployeeMapper.toEmployee(employeeRepository.getOne(id));
    }

    public Employee create(Employee employee) {
        return EmployeeMapper.toEmployee(employeeRepository.save(EmployeeMapper.toEmployee(employee)));
    }

    public List<EmployeeDto> getAll() {
        List<Employee> employees = EmployeeMapper.toEmployeesList(employeeRepository.findAll());
        return EmployeeMapper.toEmployeesDtoList(employees);
    }

    public Employee update(Employee employee) {
        if(!employeeRepository.existsById(employee.getId())) {
            throw new EntityNotFoundException("Employee with id " + employee.getId() + " does not exist");
        }
        EmployeEntity savedEmployee = employeeRepository.save(EmployeeMapper.toEmployee((employee)));
        return EmployeeMapper.toEmployee(savedEmployee);
    }

    public void delete(Long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }
}
