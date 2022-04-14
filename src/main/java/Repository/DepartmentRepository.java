package Repository;

import Model.*;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentsEntity, Integer> {
}
