package az.maqa.spring.data.specification.service;

import az.maqa.spring.data.specification.entity.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    List<Employee> getEqualAge(Integer age);

    List<Employee> getGreaterThanSalary(Double salary);

    List<Employee> getLessThanSalary(Double salary);

    List<Employee> getNameLike(String name);

    List<Employee> betweenSalary(Double minSalary, Double maxSalary);

    List<Employee> findEmployeeByNameAndHireDateAndSalary(String name, Date hireDate, Double salary);
}
