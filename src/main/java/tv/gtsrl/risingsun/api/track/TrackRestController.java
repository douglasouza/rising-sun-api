package tv.gtsrl.risingsun.api.track;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/track")
public class TrackRestController {

    @Autowired
    private TrackRepository trackRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody Track track) {
        return trackRepo.save(track);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return trackRepo.findAll();
    }

}