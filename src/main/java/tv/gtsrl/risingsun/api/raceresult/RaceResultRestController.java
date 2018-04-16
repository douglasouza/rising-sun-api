package tv.gtsrl.risingsun.api.raceresult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/race-result")
public class RaceResultRestController {

    @Autowired
    private RaceResultRepository raceResultRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody RaceResult raceResult) {
        return raceResultRepo.save(raceResult);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return raceResultRepo.findAll();
    }

}