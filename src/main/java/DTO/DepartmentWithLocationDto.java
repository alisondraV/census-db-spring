package DTO;

/**
 * A Data Transfer Object used to represent extended department information
 */
public class DepartmentWithLocationDto {
    String name;
    String city;
    String state;

    public DepartmentWithLocationDto(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DepartmentWithLocationDto{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
