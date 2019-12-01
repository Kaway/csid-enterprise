package fr.univparis8.iut.csid.employee;

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

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable long id, @RequestParam String name) {
        return employeeService.find(id)
                .map(e -> EmployeeDto.EmployeeDtoBuilder
                        .create()
                        .withId(e.getId())
                        .withFirstName(e.getFirstName())
                        .withLastName(e.getLastName())
                        .build()
                ).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) throws URISyntaxException {
        Employee newEmployee = employeeService.create(EmployeeMapper.toEmployee(employeeDto));

        URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{id}")
                .buildAndExpand(newEmployee.getId())
                .toUri().getPath()
        );

        return ResponseEntity.created(uri).body(EmployeeMapper.toEmployeeDto(newEmployee));
    }

}
