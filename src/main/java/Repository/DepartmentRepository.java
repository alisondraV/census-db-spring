package Repository;

import DTO.DepartmentWithLocationDto;
import Model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * A collection of methods for querying departments
 */
public interface DepartmentRepository extends CrudRepository<DepartmentsEntity, Integer> {
    DepartmentsEntity findByDepartmentName(String name);
    List<DepartmentsEntity> findByLocationId(Integer id);
    @Query("SELECT new DTO.DepartmentWithLocationDto(d.departmentName, l.city, l.stateProvince) FROM DepartmentsEntity AS d " +
           "JOIN LocationsEntity AS l ON d.locationId = l.locationId")
    List<DepartmentWithLocationDto> getDepartmentsWithLocations();
}
