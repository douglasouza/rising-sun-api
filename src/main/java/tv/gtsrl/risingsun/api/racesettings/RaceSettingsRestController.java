package tv.gtsrl.risingsun.api.racesettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/race-settings")
public class RaceSettingsRestController {

    @Autowired
    private RaceSettingsRepository raceSettingsRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody RaceSettings raceSettings) {
        return raceSettingsRepo.save(raceSettings);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return raceSettingsRepo.findAll();
    }

}