package fr.univparis8.iut.csid.employee;

import fr.univparis8.iut.csid.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee get(Long id) {
        try {
            return EmployeeMapper.toEmployee(employeeRepository.getOne(id));
        } catch (PersistenceException ex) {
            throw new ObjectNotFoundException("Employee with id " + id + " not found");
        }
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
            throw new ObjectNotFoundException("Employee with id " + employee.getId() + " does not exist");
        }
        EmployeEntity savedEmployee = employeeRepository.save(EmployeeMapper.toEmployee((employee)));
        return EmployeeMapper.toEmployee(savedEmployee);
    }

    public Employee partialUpdate(Employee employee) {
        if(!employeeRepository.existsById(employee.getId())) {
            throw new ObjectNotFoundException("Employee with id " + employee.getId() + " does not exist");
        }

        Employee currentEmployee = EmployeeMapper.toEmployee(employeeRepository.getOne(employee.getId()));
        Employee mergedEmployee = currentEmployee.mergeWith(employee);

        EmployeEntity newEmployee = employeeRepository.save(EmployeeMapper.toEmployee(mergedEmployee));

        return EmployeeMapper.toEmployee(newEmployee);
    }

    public void delete(Long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }
}
