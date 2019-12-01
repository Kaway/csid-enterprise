package fr.univparis8.iut.csid.employee;

import fr.univparis8.iut.csid.exception.IdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return EmployeeMapper.toEmployeeDto(employeeService.get(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) throws URISyntaxException {

        if(employeeDto.getId() != null) {
            throw new IllegalArgumentException("Employee id should not be populated when creating and employee");
        }

        Employee newEmployee = employeeService.create(EmployeeMapper.toEmployee(employeeDto));

        URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{id}")
                .buildAndExpand(newEmployee.getId())
                .toUri().getPath()
        );

        return ResponseEntity.created(uri).body(EmployeeMapper.toEmployeeDto(newEmployee));
    }

    @PutMapping("{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        if(employeeDto.getId() == null) {
            throw new IllegalArgumentException("Employee id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(employeeDto.getId())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        Employee updatedEmployee = employeeService.update(EmployeeMapper.toEmployee(employeeDto));
        return EmployeeMapper.toEmployeeDto(updatedEmployee);
    }

    @PatchMapping("{id}")
    public EmployeeDto partialUpdateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        if(employeeDto.getId() == null) {
            throw new IllegalArgumentException("Employee id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(employeeDto.getId())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        Employee updatedEmployee = employeeService.partialUpdate(EmployeeMapper.toEmployee(employeeDto));
        return EmployeeMapper.toEmployeeDto(updatedEmployee);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }

}
