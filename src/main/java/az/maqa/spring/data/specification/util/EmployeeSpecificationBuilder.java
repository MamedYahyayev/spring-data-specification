package az.maqa.spring.data.specification.util;

import az.maqa.spring.data.specification.domain.SearchCriteria;
import az.maqa.spring.data.specification.domain.enums.QueryOperator;
import az.maqa.spring.data.specification.entity.Employee;
import az.maqa.spring.data.specification.query.EmployeeSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSpecificationBuilder {

    private final List<SearchCriteria> params;


    public EmployeeSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public void with(String key, QueryOperator operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
    }

    public Specification<Employee> build() {
        if (params.size() == 0)
            return null;

        List<Specification<Employee>> specs = params.stream()
                .map(EmployeeSpecification::createSpecification).collect(Collectors.toList());

        Specification<Employee> result = specs.get(0);

        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }

        return result;
    }
}
