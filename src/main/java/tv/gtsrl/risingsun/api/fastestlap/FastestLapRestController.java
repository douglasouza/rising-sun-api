package tv.gtsrl.risingsun.api.fastestlap;

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
@RequestMapping("/rising-sun/race/{raceId}/fastest-lap")
public class FastestLapRestController {

    @Autowired
    private FastestLapRepository repo;

    @Autowired
    private FastestLapBO bo;

    @PostMapping
    public FastestLap insert(@PathVariable("raceId") Long raceId, @RequestBody FastestLap fastestLap) {
        return bo.insert(raceId, fastestLap);
    }

    @PutMapping
    public FastestLap update(@PathVariable("fastestLapId") Long fastestLapId, @RequestBody FastestLap updatedFastestLap) {
        return bo.update(fastestLapId, updatedFastestLap);
    }

    @DeleteMapping(path = "/{fastestLapId}")
    public void delete(@PathVariable("fastestLapId") Long fastestLapId) {
        repo.deleteById(fastestLapId);
    }

    @GetMapping
    public List<FastestLap> getAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{fastestLapId}")
    public FastestLap getOne(@PathVariable("fastestLapId") Long fastestLapId) {
        return repo.getOne(fastestLapId);
    }

}