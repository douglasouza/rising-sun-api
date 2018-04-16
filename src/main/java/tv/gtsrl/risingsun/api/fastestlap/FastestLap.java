package tv.gtsrl.risingsun.api.fastestlap;

import tv.gtsrl.risingsun.api.driver.Driver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class FastestLap {

    @Id
    @Column(name = "fl_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fl_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fastestLapTime;

    @JoinColumn(name = "dr_id")
    @ManyToOne
    private Driver driver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFastestLapTime() {
        return fastestLapTime;
    }

    public void setFastestLapTime(Date fastestLapTime) {
        this.fastestLapTime = fastestLapTime;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
