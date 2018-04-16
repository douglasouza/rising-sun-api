package tv.gtsrl.risingsun.api.driver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {

    @Id
    @Column(name = "dr_id")
    private Long id;

    @Column(name = "dr_name", nullable = false)
    private String name;

    @Column(name = "dr_country", nullable = false)
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
