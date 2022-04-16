package Repository;

import DTO.EmployeeDto;
import Model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {
    List<EmployeesEntity> findBySalaryBetween(BigDecimal min, BigDecimal max);
    List<EmployeesEntity> findByFirstNameEndsWith(Character letter);
    List<EmployeesEntity> findByDepartmentId(Integer id);
    List<EmployeesEntity> findByManagerId(Integer id);
    EmployeesEntity findByEmployeeId(Integer id);

    @Query("SELECT new DTO.EmployeeDto(e.lastName, j.jobTitle, d.departmentId, d.departmentName) FROM EmployeesEntity AS e " +
            "JOIN JobsEntity AS j ON e.jobId = j.jobId " +
            "JOIN DepartmentsEntity AS d ON e.departmentId = d.departmentId " +
            "JOIN LocationsEntity AS l ON d.locationId = l.locationId " +
            "WHERE l.city = :#{#city}")
    List<EmployeeDto> findEmployeesEntitiesByCity(@Param("city") String city);

    @Query("SELECT DISTINCT emp.managerId FROM EmployeesEntity emp")
    List<Integer> getDistinctManagerId();
}
