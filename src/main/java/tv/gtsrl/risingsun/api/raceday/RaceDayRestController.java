package tv.gtsrl.risingsun.api.raceday;

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
@RequestMapping("/rising-sun/race-day")
public class RaceDayRestController {

    @Autowired
    private RaceDayRepository raceDayRepo;

    @Autowired
    private RaceDayBO bo;

    @PostMapping
    public RaceDay insert(@RequestBody RaceDay raceDay) {
        return bo.insert(raceDay);
    }

    @PutMapping(path = "/{raceDayId}")
    public RaceDay update(@PathVariable("raceDayId") Long raceDayId, @RequestBody RaceDay updatedRaceDay) {
        return bo.update(raceDayId, updatedRaceDay);
    }

    @DeleteMapping(path = "/{raceDayId}")
    public void delete(@PathVariable("raceDayId") Long raceDayId) {
        bo.delete(raceDayId);
    }

    @GetMapping
    public List<RaceDay> getAll() {
        return raceDayRepo.findAll();
    }

    @GetMapping(path = "/{raceDayId}")
    public RaceDay getOne(@PathVariable("raceDayId") Long raceDayId) {
        return raceDayRepo.getOne(raceDayId);
    }

}