package az.maqa.spring.data.specification;

import az.maqa.spring.data.specification.entity.Employee;
import az.maqa.spring.data.specification.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class SpringDataSpecificationApplication {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataSpecificationApplication.class, args);
    }

    @PostConstruct
    public void initialize() {
        Employee employee = new Employee();
        employee.setName("Samir");
        employee.setSurname("Samirov");
        employee.setEmail("samir@gmail.com");
        employee.setSalary(1200d);
        employee.setAge(18);
        employee.setHireDate(new Date());

        Employee employee2 = new Employee();
        employee2.setName("Fazil");
        employee2.setSurname("Samirov2");
        employee2.setEmail("samir2@gmail.com");
        employee2.setSalary(1300d);
        employee2.setAge(25);
        employee2.setHireDate(new Date());

        employeeRepository.save(employee);
        employeeRepository.save(employee2);
    }

}
