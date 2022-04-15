package Repository;

import Model.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<DepartmentsEntity, Integer> {
    DepartmentsEntity findByDepartmentName(String name);
    List<DepartmentsEntity> findByLocationId(Integer id);
}
