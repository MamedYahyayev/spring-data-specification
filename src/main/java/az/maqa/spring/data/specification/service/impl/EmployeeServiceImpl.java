package az.maqa.spring.data.specification.service.impl;

import az.maqa.spring.data.specification.entity.Employee;
import az.maqa.spring.data.specification.repository.EmployeeRepository;
import az.maqa.spring.data.specification.service.EmployeeService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static az.maqa.spring.data.specification.query.EmployeeSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEqualAge(Integer age) {
        Specification<Employee> spec = equalAge(age);
        return employeeRepository.findAll(spec);
    }

    @Override
    public List<Employee> getGreaterThanSalary(Double salary) {
        Specification<Employee> spec = greaterThanSalary(salary);
        return employeeRepository.findAll(spec);
    }

    @Override
    public List<Employee> getLessThanSalary(Double salary) {
        Specification<Employee> spec = lessThanSalary(salary);
        return employeeRepository.findAll(spec);
    }

    @Override
    public List<Employee> getNameLike(String name) {
        Specification<Employee> spec = likeNameQuery(name);
        return employeeRepository.findAll(spec);
    }

    @Override
    public List<Employee> betweenSalary(Double minSalary, Double maxSalary) {
        Specification<Employee> lessThanSalary = lessThanSalary(maxSalary);
        Specification<Employee> greaterThanSalary = greaterThanSalary(minSalary);
        return employeeRepository.findAll(where(lessThanSalary).and(greaterThanSalary));
    }

    @Override
    public List<Employee> findEmployeeByNameAndHireDateAndSalary(String name, Date hireDate, Double salary) {
        Specification<Employee> equalName = equalName(name);
        Specification<Employee> equalHireDate = equalHireDate(hireDate);
        Specification<Employee> equalSalary = equalSalary(salary);
        return employeeRepository.findAll(where(equalName).and(equalHireDate).and(equalSalary));
    }

}
