package az.maqa.spring.data.specification.service.impl;

import az.maqa.spring.data.specification.domain.SearchCriteria;
import az.maqa.spring.data.specification.entity.Employee;
import az.maqa.spring.data.specification.query.EmployeeSpecification;
import az.maqa.spring.data.specification.repository.EmployeeRepository;
import az.maqa.spring.data.specification.service.EmployeeService;
import az.maqa.spring.data.specification.util.EmployeeSpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static az.maqa.spring.data.specification.domain.enums.QueryOperator.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEqualAge(Integer age) {
        SearchCriteria searchCriteria = new SearchCriteria("age", EQUALS, age);
        return getResult(searchCriteria);
    }

    @Override
    public List<Employee> getGreaterThanSalary(Double salary) {
        SearchCriteria searchCriteria = new SearchCriteria("salary", GREATER_THAN, salary);
        return getResult(searchCriteria);
    }

    @Override
    public List<Employee> getLessThanSalary(Double salary) {
        SearchCriteria searchCriteria = new SearchCriteria("salary", LESS_THAN, salary);
        return getResult(searchCriteria);
    }

    @Override
    public List<Employee> getNameLike(String name) {
        SearchCriteria searchCriteria = new SearchCriteria("name", LIKE, name);
        return getResult(searchCriteria);
    }

    @Override
    public List<Employee> betweenSalary(Double minSalary, Double maxSalary) {
        EmployeeSpecificationBuilder builder = new EmployeeSpecificationBuilder();
        builder.with("salary", GREATER_THAN, minSalary);
        builder.with("salary", LESS_THAN, maxSalary);
        Specification<Employee> specs = builder.build();
        return employeeRepository.findAll(specs);
    }

    @Override
    public List<Employee> findEmployeeByNameAndHireDateAndSalary(String name, Date hireDate, Double salary) {
        EmployeeSpecificationBuilder builder = new EmployeeSpecificationBuilder();
        builder.with("name", EQUALS, name);
        builder.with("hireDate", EQUALS, hireDate);
        builder.with("salary", EQUALS, salary);
        Specification<Employee> specs = builder.build();
        return employeeRepository.findAll(specs);
    }

    private List<Employee> getResult(SearchCriteria searchCriteria) {
        Specification<Employee> spec = EmployeeSpecification.createSpecification(searchCriteria);
        return employeeRepository.findAll(spec);
    }
}
