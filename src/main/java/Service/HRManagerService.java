package Service;

import Model.EmployeesEntity;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("hrManagerService")
public class HRManagerService {
    @Autowired
    private EmployeeRepository empRepository;
    @Autowired
    private DepartmentRepository depRepository;

    public void test() {
        List<EmployeesEntity> employeesSalary = empRepository.findBySalaryBetween(BigDecimal.valueOf(9000), BigDecimal.valueOf(17000));
        employeesSalary.forEach(System.out::println);

        List<EmployeesEntity> employeesLastName = empRepository.findByLastNameEndsWith("a");
        employeesLastName.forEach(System.out::println);
    }
}
