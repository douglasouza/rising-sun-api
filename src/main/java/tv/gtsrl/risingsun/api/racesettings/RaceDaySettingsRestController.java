package tv.gtsrl.risingsun.api.racesettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rising-sun/race-day/{raceDay}/race-settings")
public class RaceDaySettingsRestController {

    @Autowired
    private RaceDaySettingsRepository repo;

    @Autowired
    private RaceDaySettingsBO bo;

    @PostMapping
    public RaceDaySettings insert(@PathVariable("raceId") Long raceId, @RequestBody RaceDaySettings raceDaySettings) {
        return bo.insert(raceId, raceDaySettings);
    }

    @PutMapping
    public RaceDaySettings update(@PathVariable("raceDaySettingsId") Long raceDaySettingsId, @RequestBody RaceDaySettings updatedRaceDaySettings) {
        return bo.update(raceDaySettingsId, updatedRaceDaySettings);
    }

    @DeleteMapping(path = "/{raceDaySettingsId}")
    public void delete(@PathVariable("raceDaySettingsId") Long raceDaySettingsId) {
        repo.deleteById(raceDaySettingsId);
    }

    @GetMapping
    public List<RaceDaySettings> getAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{raceDaySettingsId}")
    public RaceDaySettings getOne(@PathVariable("raceDaySettingsId") Long raceDaySettingsId) {
        return repo.getOne(raceDaySettingsId);
    }

}