package tv.gtsrl.risingsun.api.raceresult;

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
@RequestMapping("/rising-sun/race/{raceId}/race-result")
public class RaceResultRestController {

    @Autowired
    private RaceResultRepository repo;

    @Autowired
    private RaceResultBO bo;

    @PostMapping
    public RaceResult insert(@PathVariable("raceId") Long raceId, @RequestBody RaceResult raceResult) {
        return bo.insert(raceId, raceResult);
    }

    @PutMapping
    public RaceResult update(@PathVariable("raceResultId") Long raceResultId, @RequestBody RaceResult updatedRaceResult) {
        return bo.update(raceResultId, updatedRaceResult);
    }

    @DeleteMapping(path = "/{raceResultId}")
    public void delete(@PathVariable("raceResultId") Long raceResultId) {
        repo.deleteById(raceResultId);
    }

    @GetMapping
    public List<RaceResult> getAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{raceResultId}")
    public RaceResult getOne(@PathVariable("raceResultId") Long raceResultId) {
        return repo.getOne(raceResultId);
    }

}