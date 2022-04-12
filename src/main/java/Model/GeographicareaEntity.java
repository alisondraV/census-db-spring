package Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "GEOGRAPHICAREA", schema = "CENSUSDB", catalog = "")
public class GeographicareaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "geographicAreaID", nullable = false)
    private int geographicAreaId;
    @Basic
    @Column(name = "code", nullable = false)
    private int code;
    @Basic
    @Column(name = "level", nullable = false)
    private int level;
    @Basic
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Basic
    @Column(name = "alternativeCode", nullable = false)
    private int alternativeCode;
    @OneToMany(mappedBy = "geographicareaByGeographicArea")
    private Collection<AgeEntity> agesByGeographicAreaId;
    @OneToMany(mappedBy = "geographicareaByGeographicArea")
    private Collection<HouseholdEntity> householdsByGeographicAreaId;

    public int getGeographicAreaId() {
        return geographicAreaId;
    }

    public void setGeographicAreaId(int geographicAreaId) {
        this.geographicAreaId = geographicAreaId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlternativeCode() {
        return alternativeCode;
    }

    public void setAlternativeCode(int alternativeCode) {
        this.alternativeCode = alternativeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeographicareaEntity that = (GeographicareaEntity) o;
        return geographicAreaId == that.geographicAreaId && code == that.code && level == that.level && alternativeCode == that.alternativeCode && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geographicAreaId, code, level, name, alternativeCode);
    }

    public Collection<AgeEntity> getAgesByGeographicAreaId() {
        return agesByGeographicAreaId;
    }

    public void setAgesByGeographicAreaId(Collection<AgeEntity> agesByGeographicAreaId) {
        this.agesByGeographicAreaId = agesByGeographicAreaId;
    }

    public Collection<HouseholdEntity> getHouseholdsByGeographicAreaId() {
        return householdsByGeographicAreaId;
    }

    public void setHouseholdsByGeographicAreaId(Collection<HouseholdEntity> householdsByGeographicAreaId) {
        this.householdsByGeographicAreaId = householdsByGeographicAreaId;
    }
}
