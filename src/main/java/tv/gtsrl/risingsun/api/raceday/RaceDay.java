package tv.gtsrl.risingsun.api.raceday;

import tv.gtsrl.risingsun.api.season.Season;
import tv.gtsrl.risingsun.common.enumeration.EventFormatEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class RaceDay {

    @Id
    @Column(name = "rd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rd_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "rd_lobby_host", nullable = false)
    private String lobbyHost;

    @Column(name = "rd_event_format", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventFormatEnum eventFormat;

    @JoinColumn(name = "se_id")
    @ManyToOne
    private Season season;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLobbyHost() {
        return lobbyHost;
    }

    public void setLobbyHost(String lobbyHost) {
        this.lobbyHost = lobbyHost;
    }

    public EventFormatEnum getEventFormat() {
        return eventFormat;
    }

    public void setEventFormat(EventFormatEnum eventFormat) {
        this.eventFormat = eventFormat;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}