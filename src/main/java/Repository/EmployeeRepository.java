package Repository;

import Model.*;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {
    List<EmployeesEntity> findBySalaryBetween(BigDecimal min, BigDecimal max);
    List<EmployeesEntity> findByLastNameEndsWith(String letter);
}
