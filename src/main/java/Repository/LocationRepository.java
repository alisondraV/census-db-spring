package Repository;

import DTO.CountryCityDto;
import Model.LocationsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * A collection of methods for querying locations
 */
public interface LocationRepository extends CrudRepository<LocationsEntity, Integer> {
    @Query("SELECT new DTO.CountryCityDto(countryId, COUNT(city)) FROM LocationsEntity GROUP BY countryId")
    List<CountryCityDto> countCitiesByCountry();
}
