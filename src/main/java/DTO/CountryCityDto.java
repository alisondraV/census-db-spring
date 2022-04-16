package DTO;

/**
 * A Data Transfer Object used to represent country cities count
 */
public class CountryCityDto {
    String countryId;
    Long cityCount;

    public CountryCityDto(String countryId, Long cityCount) {
        this.countryId = countryId;
        this.cityCount = cityCount;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Long getCityCount() {
        return cityCount;
    }

    public void setCityCount(Long cityCount) {
        this.cityCount = cityCount;
    }

    @Override
    public String toString() {
        return countryId + " has " + cityCount + " cities";
    }
}
