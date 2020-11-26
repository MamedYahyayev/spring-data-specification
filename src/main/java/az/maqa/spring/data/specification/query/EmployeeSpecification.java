package az.maqa.spring.data.specification.query;

import az.maqa.spring.data.specification.entity.Employee;
import az.maqa.spring.data.specification.entity.Employee_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class EmployeeSpecification {

    public static Specification<Employee> equalAge(Integer age) {
        return (root, query, builder) -> builder.equal(root.get(Employee_.age), age);
    }

    public static Specification<Employee> greaterThanSalary(Double salary) {
        return (root, query, builder) -> builder.greaterThan(root.get(Employee_.salary), salary);
    }

    public static Specification<Employee> lessThanSalary(Double salary) {
        return (root, query, builder) -> builder.lessThan(root.get(Employee_.salary), salary);
    }

    public static Specification<Employee> likeNameQuery(String name) {
        return (root, query, builder) -> builder.like(root.get(Employee_.name), "%" + name + "%");
    }

    public static Specification<Employee> equalName(String name) {
        return (root, query, builder) -> builder.equal(root.get(Employee_.name), name);
    }

    public static Specification<Employee> equalHireDate(Date hireDate) {
        return (root, query, builder) -> builder.equal(root.get(Employee_.hireDate), hireDate);
    }

    public static Specification<Employee> equalSalary(Double salary) {
        return (root, query, builder) -> builder.equal(root.get(Employee_.salary), salary);
    }

}
