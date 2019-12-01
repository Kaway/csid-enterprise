package fr.univparis8.iut.csid.employee;

import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeMapper {

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return EmployeeDto.EmployeeDtoBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .build();
    }

    public static Employee toEmployee(EmployeeDto employee) {
        return Employee.EmployeeBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .build();
    }

    public static Employee toEmployee(EmployeEntity employee) {
        return Employee.EmployeeBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .build();
    }

    public static EmployeEntity toEmployee(Employee employee) {
        return EmployeEntity.EmployeEntityBuilder.create()
                .withId(employee.getId())
                .withFirstName(employee.getFirstName())
                .withLastName(employee.getLastName())
                .build();
    }

    public static List<Employee> toEmployeesList(List<EmployeEntity> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployee)
                .collect(Collectors.toList());
    }

    public static List<EmployeeDto> toEmployeesDtoList(List<Employee> employeeEntities) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployeeDto)
                .collect(Collectors.toList());
    }



}
