package tv.gtsrl.risingsun.api.race;

import tv.gtsrl.risingsun.api.raceday.RaceDay;
import tv.gtsrl.risingsun.api.track.Track;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Race {

    @Id
    @Column(name = "ra_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ra_number_of_laps", nullable = false)
    private Integer numberOfLaps;

    @JoinColumn(name = "tr_id", nullable = false)
    @ManyToOne
    private Track track;

    @JoinColumn(name = "rd_id", nullable = false)
    @ManyToOne
    private RaceDay raceDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfLaps() {
        return numberOfLaps;
    }

    public void setNumberOfLaps(Integer numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public RaceDay getRaceDay() {
        return raceDay;
    }

    public void setRaceDay(RaceDay raceDay) {
        this.raceDay = raceDay;
    }
}
