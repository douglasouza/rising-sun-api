package tv.gtsrl.risingsun.api.fastestlap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/fastest-lap")
public class FastestLapRestController {

    @Autowired
    private FastestLapRepository fastestLapRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody FastestLap fastestLap) {
        return fastestLapRepo.save(fastestLap);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return fastestLapRepo.findAll();
    }

}