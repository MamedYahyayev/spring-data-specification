package az.maqa.spring.data.specification.query;

import az.maqa.spring.data.specification.domain.SearchCriteria;
import az.maqa.spring.data.specification.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> createSpecification(SearchCriteria criteria) {
        switch (criteria.getOperation()) {
            case EQUALS:
                return (root, query, builder) -> builder.equal(root.get(criteria.getKey()), criteria.getValue());
            case GREATER_THAN:
                return (root, query, builder) -> builder.gt(root.get(criteria.getKey()), (Number) criteria.getValue());
            case LESS_THAN:
                return (root, query, builder) -> builder.lt(root.get(criteria.getKey()), (Number) criteria.getValue());
            case LIKE:
                return (root, query, builder) -> builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            default:
                throw new RuntimeException("Operation not supported yet");
        }
    }
}
