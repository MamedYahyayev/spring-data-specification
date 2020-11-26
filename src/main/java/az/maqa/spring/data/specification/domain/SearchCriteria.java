package az.maqa.spring.data.specification.domain;

import az.maqa.spring.data.specification.domain.enums.QueryOperator;

public class SearchCriteria {
    private String key;
    private QueryOperator operation;
    private Object value;
    private Object[] values;


    public SearchCriteria() {
    }

    public SearchCriteria(String key, QueryOperator operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public SearchCriteria(String key, QueryOperator operation, Object value, Object[] values) {
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.values = values;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public QueryOperator getOperation() {
        return operation;
    }

    public void setOperation(QueryOperator operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }
}
