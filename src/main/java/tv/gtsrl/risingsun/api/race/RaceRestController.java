package tv.gtsrl.risingsun.api.race;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/race")
public class RaceRestController {

    @Autowired
    private RaceRepository raceRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody Race race) {
        return raceRepo.save(race);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return raceRepo.findAll();
    }

}