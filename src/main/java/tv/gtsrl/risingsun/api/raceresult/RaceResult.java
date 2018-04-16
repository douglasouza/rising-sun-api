package tv.gtsrl.risingsun.api.raceresult;

import tv.gtsrl.risingsun.api.car.Car;
import tv.gtsrl.risingsun.api.driver.Driver;
import tv.gtsrl.risingsun.api.race.Race;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class RaceResult {

    @Id
    @Column(name = "rr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rr_start_position", nullable = false)
    private Integer startPosition;

    @Column(name = "rr_finish_position", nullable = false)
    private Integer finishPosition;

    @Column(name = "rr_race_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date raceTime;

    @JoinColumn(name = "dr_id", nullable = false)
    @ManyToOne
    private Driver driver;

    @JoinColumn(name = "cr_id", nullable = false)
    @ManyToOne
    private Car car;

    @JoinColumn(name = "ra_id", nullable = false)
    @ManyToOne
    private Race race;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getFinishPosition() {
        return finishPosition;
    }

    public void setFinishPosition(Integer finishPosition) {
        this.finishPosition = finishPosition;
    }

    public Date getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(Date raceTime) {
        this.raceTime = raceTime;
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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
