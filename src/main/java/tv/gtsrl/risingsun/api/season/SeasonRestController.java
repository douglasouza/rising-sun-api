package tv.gtsrl.risingsun.api.season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/season")
public class SeasonRestController {

    @Autowired
    private SeasonRepository seasonRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody Season season) {
        return seasonRepo.save(season);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return seasonRepo.findAll();
    }

}