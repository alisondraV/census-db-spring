package Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "HOUSEHOLDEARNERS", schema = "CENSUSDB", catalog = "")
public class HouseholdearnersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private short id;
    @Basic
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    @OneToMany(mappedBy = "householdearnersByHouseholdEarners")
    private Collection<HouseholdEntity> householdsById;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseholdearnersEntity that = (HouseholdearnersEntity) o;
        return id == that.id && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    public Collection<HouseholdEntity> getHouseholdsById() {
        return householdsById;
    }

    public void setHouseholdsById(Collection<HouseholdEntity> householdsById) {
        this.householdsById = householdsById;
    }
}
