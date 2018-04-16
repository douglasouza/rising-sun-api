package tv.gtsrl.risingsun.api.race;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/race-day/{raceDayId}/race")
public class RaceRestController {

    @Autowired
    private RaceRepository repo;

    @Autowired
    private RaceBO bo;

    @RequestMapping(method = RequestMethod.POST)
    public Race insert(@PathVariable("raceDayId") Long raceDayId, @RequestBody Race race) {
        return bo.insertRace(raceDayId, race);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return repo.findAll();
    }

}