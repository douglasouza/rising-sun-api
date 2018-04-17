package tv.gtsrl.risingsun.api.racesettings;

import tv.gtsrl.risingsun.api.carclass.CarClass;
import tv.gtsrl.risingsun.api.raceday.RaceDay;
import tv.gtsrl.risingsun.common.enumeration.BoostEnum;
import tv.gtsrl.risingsun.common.enumeration.MechanicalDamageEnum;
import tv.gtsrl.risingsun.common.enumeration.SlipstreamEnum;
import tv.gtsrl.risingsun.common.enumeration.StartTypeEnum;
import tv.gtsrl.risingsun.common.enumeration.TireWearFuelConsumptionEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class RaceDaySettings {

    @Id
    @Column(name = "rs_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rs_start", nullable = false)
    @Enumerated(EnumType.STRING)
    private StartTypeEnum startType;

    @Column(name = "rs_boost", nullable = false)
    @Enumerated(EnumType.STRING)
    private BoostEnum boost;

    @Column(name = "rs_slipstream", nullable = false)
    @Enumerated(EnumType.STRING)
    private SlipstreamEnum slipstream;

    @Column(name = "rs_mechanical_damage", nullable = false)
    @Enumerated(EnumType.STRING)
    private MechanicalDamageEnum mechanicalDamage;

    @Column(name = "rs_tire_wear", nullable = false)
    @Enumerated(EnumType.STRING)
    private TireWearFuelConsumptionEnum tireWear;

    @Column(name = "rs_fuel_consumption", nullable = false)
    @Enumerated(EnumType.STRING)
    private TireWearFuelConsumptionEnum fuelConsumption;

    @Column(name = "rs_bop", nullable = false)
    private Boolean bop;

    @Column(name = "rs_tuning", nullable = false)
    private Boolean tunningAllowed;

//    @Column(name = "rs_tire_selection", nullable = false)
//    @Enumerated(EnumType.STRING)
//    private TireTypesEnum tireSelection;
//
//    @Column(name = "rs_ghosting", nullable = false)
//    private Boolean ghosting;
//
//    @Column(name = "rs_auto_recovery", nullable = false)
//    private Boolean autoRecovery;

    @ManyToMany
    @JoinTable(name = "racedaysettings_carclass",
            joinColumns = {@JoinColumn(name = "se_id")},
            inverseJoinColumns = {@JoinColumn(name = "cc_id")})
    private List<CarClass> carClass;

    @JoinColumn(name = "rd_id", nullable = false)
    @ManyToOne
    private RaceDay raceDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StartTypeEnum getStartType() {
        return startType;
    }

    public void setStartType(StartTypeEnum startType) {
        this.startType = startType;
    }

    public BoostEnum getBoost() {
        return boost;
    }

    public void setBoost(BoostEnum boost) {
        this.boost = boost;
    }

    public SlipstreamEnum getSlipstream() {
        return slipstream;
    }

    public void setSlipstream(SlipstreamEnum slipstream) {
        this.slipstream = slipstream;
    }

    public MechanicalDamageEnum getMechanicalDamage() {
        return mechanicalDamage;
    }

    public void setMechanicalDamage(MechanicalDamageEnum mechanicalDamage) {
        this.mechanicalDamage = mechanicalDamage;
    }

    public TireWearFuelConsumptionEnum getTireWear() {
        return tireWear;
    }

    public void setTireWear(TireWearFuelConsumptionEnum tireWear) {
        this.tireWear = tireWear;
    }

    public TireWearFuelConsumptionEnum getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(TireWearFuelConsumptionEnum fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Boolean getBop() {
        return bop;
    }

    public void setBop(Boolean bop) {
        this.bop = bop;
    }

    public Boolean getTunningAllowed() {
        return tunningAllowed;
    }

    public void setTunningAllowed(Boolean tunningAllowed) {
        this.tunningAllowed = tunningAllowed;
    }

    public List<CarClass> getCarClass() {
        return carClass;
    }

    public void setCarClass(List<CarClass> carClass) {
        this.carClass = carClass;
    }

    public RaceDay getRaceDay() {
        return raceDay;
    }

    public void setRaceDay(RaceDay raceDay) {
        this.raceDay = raceDay;
    }
}
