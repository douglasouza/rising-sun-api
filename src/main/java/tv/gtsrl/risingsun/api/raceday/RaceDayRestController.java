package tv.gtsrl.risingsun.api.raceday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/race-day")
public class RaceDayRestController {

    @Autowired
    private RaceDayRepository raceDayRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody RaceDay raceDay) {
        return raceDayRepo.save(raceDay);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return raceDayRepo.findAll();
    }

}