package Repository;

import Model.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Long> {
    List<EmployeesEntity> findByLastName(String lastName);
}
