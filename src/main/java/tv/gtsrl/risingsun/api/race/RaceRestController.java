package tv.gtsrl.risingsun.api.race;

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
@RequestMapping("/rising-sun/race-day/{raceDayId}/race")
public class RaceRestController {

    @Autowired
    private RaceRepository repo;

    @Autowired
    private RaceBO bo;

    @PostMapping
    public Race insert(@PathVariable("raceDayId") Long raceDayId, @RequestBody Race race) {
        return bo.insert(raceDayId, race);
    }

    @PutMapping
    public Race update(@PathVariable("raceId") Long raceId, @RequestBody Race updatedRace) {
        return bo.update(raceId, updatedRace);
    }

    @DeleteMapping(path = "/{raceId}")
    public void delete(@PathVariable("raceId") Long raceId) {
        bo.delete(raceId);
    }

    @GetMapping
    public List<Race> getAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{raceId}")
    public Race getOne(@PathVariable("raceId") Long raceId) {
        return repo.getOne(raceId);
    }

}