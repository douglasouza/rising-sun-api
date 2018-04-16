package tv.gtsrl.risingsun.api.qualifyingresult;

import tv.gtsrl.risingsun.api.car.Car;
import tv.gtsrl.risingsun.api.driver.Driver;
import tv.gtsrl.risingsun.api.raceday.RaceDay;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class QualifyingResult {

    @Id
    @Column(name = "qr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qr_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date qualifyingTime;

    @JoinColumn(name = "dr_id")
    @ManyToOne
    private Driver driver;

    @JoinColumn(name = "cr_id")
    @ManyToOne
    private Car car;

    @JoinColumn(name = "rd_id")
    @ManyToOne
    private RaceDay raceDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getQualifyingTime() {
        return qualifyingTime;
    }

    public void setQualifyingTime(Date qualifyingTime) {
        this.qualifyingTime = qualifyingTime;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public RaceDay getRaceDay() {
        return raceDay;
    }

    public void setRaceDay(RaceDay raceDay) {
        this.raceDay = raceDay;
    }
}
