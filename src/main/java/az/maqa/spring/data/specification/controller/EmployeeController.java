package az.maqa.spring.data.specification.controller;

import az.maqa.spring.data.specification.entity.Employee;
import az.maqa.spring.data.specification.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/age/{age}")
    public ResponseEntity<List<Employee>> getEqualAge(@PathVariable Integer age) {
        List<Employee> employeeList = employeeService.getEqualAge(age);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping(value = "/salary/gt/{salary}")
    public ResponseEntity<List<Employee>> getGreaterThanSalary(@PathVariable Double salary) {
        List<Employee> employeeList = employeeService.getGreaterThanSalary(salary);
        return ResponseEntity.ok(employeeList);
    }


    @GetMapping(value = "/salary/ls/{salary}")
    public ResponseEntity<List<Employee>> getLessThanSalary(@PathVariable Double salary) {
        List<Employee> employeeList = employeeService.getLessThanSalary(salary);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping(value = "/name/like/{name}")
    public ResponseEntity<List<Employee>> getNameLike(@PathVariable String name) {
        List<Employee> employeeList = employeeService.getNameLike(name);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping(value = "/salary/between/{minSalary}/{maxSalary}")
    public ResponseEntity<List<Employee>> betweenSalary(@PathVariable Double minSalary, @PathVariable Double maxSalary) {
        List<Employee> employeeList = employeeService.betweenSalary(minSalary, maxSalary);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping(value = "/{name}/hireDate/{hireDate}/salary/{salary}")
    public ResponseEntity<List<Employee>> findEmployeeByNameAndHireDateAndSalary(@PathVariable String name,
                                                                                 @PathVariable Date hireDate,
                                                                                 @PathVariable Double salary) {
        List<Employee> employeeList = employeeService.findEmployeeByNameAndHireDateAndSalary(name, hireDate, salary);
        return ResponseEntity.ok(employeeList);
    }

}
