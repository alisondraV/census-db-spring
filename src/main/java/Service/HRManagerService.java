package Service;

import DTO.CountryCityDto;
import DTO.DepartmentWithLocationDto;
import DTO.EmployeeDto;
import Model.DepartmentsEntity;
import Model.EmployeesEntity;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Tests the functionality of various repositories.
 * Produces the main output.
 */
@Service("hrManagerService")
public class HRManagerService {
    @Autowired
    private EmployeeRepository empRepository;
    @Autowired
    private DepartmentRepository depRepository;
    @Autowired
    private LocationRepository locRepository;

    /**
     * Prints out query results from different repositories
     */
    public void test() {
        // 1. Find all Employees whose salary is in the range 9000, 17000.
        System.out.println("Employees whose salary is in the range 9000, 17000:");
        List<EmployeesEntity> employeesSalary = empRepository.findBySalaryBetween(BigDecimal.valueOf(9000), BigDecimal.valueOf(17000));
        employeesSalary.forEach(System.out::println);
        System.out.println("************************************************************************************************************************************************************************************************************************");

        // 2. Find all Employees whose first name ends with Letter 'a'.
        System.out.println("Employees whose first name ends with Letter 'a':");
        List<EmployeesEntity> employeesLastName = empRepository.findByFirstNameEndsWith('a');
        employeesLastName.forEach(System.out::println);
        System.out.println("************************************************************************************************************************************************************************************************************************");

        // 3. Find all Employees working in Accounting Department.
        System.out.println("Employees working in Accounting Department:");
        DepartmentsEntity accDept = depRepository.findByDepartmentName("Accounting");
        List<EmployeesEntity> employeesAccountingDept = empRepository.findByDepartmentId(accDept.getDepartmentId());
        employeesAccountingDept.forEach(System.out::println);
        System.out.println("************************************************************************************************************************************************************************************************************************");

        // 4. Find all Employees working under Manager Id 108.
        System.out.println("Employees working under Manager Id 108:");
        List<EmployeesEntity> employeesManager = empRepository.findByManagerId(108);
        employeesManager.forEach(System.out::println);
        System.out.println("************************************************************************************************************************************************************************************************************************");

        // 5. Find all Departments with Location id 1700.
        System.out.println("Departments with Location id 1700:");
        List<DepartmentsEntity> departmentsLocation = depRepository.findByLocationId(1700);
        departmentsLocation.forEach(System.out::println);
        System.out.println("************************************************************************************************************************************************************************************************************************");

        // 6. Count the number of cities each country has. Return country ID and number of cities.
        System.out.println("Number of cities each country has. Return country ID and number of cities:");
        List<CountryCityDto> citiesCountByCountry = locRepository.countCitiesByCountry();
        citiesCountByCountry.forEach(System.out::println);
        System.out.println("************************************************************************************************************************************************************************************************************************");

        // 7. Display the department name, city, and state province for each department.
        System.out.println("Department name, city, and state province for each department:");
        List<DepartmentWithLocationDto> departmentsWithLocation = depRepository.getDepartmentsWithLocations();
        departmentsWithLocation.forEach(System.out::println);
        System.out.println("************************************************************************************************************************************************************************************************************************");

        // 8. Display the last name, job, department number and department name for all employees who work in 'Toronto' city.
        System.out.println("Last name, job, department number and department name for all employees who work in 'Toronto' city:");
        List<EmployeeDto> employees = empRepository.findEmployeesEntitiesByCity("Toronto");
        employees.forEach(System.out::println);
        System.out.println("************************************************************************************************************************************************************************************************************************");

        // 9. Display the average of sum of the salaries and group the result with the department id. Order the result with department id.
        System.out.println("Average of sum of the salaries and group the result with the department id, ordered by department id");
        List<Double> salaries = empRepository.getSalaryAverageByDepartmentId();
        salaries.forEach(System.out::println);
        System.out.println("************************************************************************************************************************************************************************************************************************");

        // 10. Select the Manager name, department id of manager, the count of employees working under that manager as Total_Employees.
        System.out.println("Manager name, department id of manager, the count of employees working under that manager as Total_Employees:");
        List<Integer> managerIds = empRepository.getDistinctManagerId();
        managerIds.forEach(id -> {
            if (id == null) return;
            EmployeesEntity manager = empRepository.findByEmployeeId(id);
            List<EmployeesEntity> employeesForManager = empRepository.findByManagerId(id);
            System.out.println("Manager: " + manager.getFirstName() + " " + manager.getLastName() +
                    ". Department ID: " + manager.getDepartmentId() + ". Total_Employees: " + employeesForManager.size());
        });
        System.out.println("************************************************************************************************************************************************************************************************************************");
    }
}
