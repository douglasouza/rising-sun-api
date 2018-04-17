package tv.gtsrl.risingsun.api.fastestlap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tv.gtsrl.risingsun.api.race.Race;
import tv.gtsrl.risingsun.api.race.RaceRepository;
import tv.gtsrl.risingsun.api.raceresult.RaceResult;
import tv.gtsrl.risingsun.common.exception.RaceResultsFastestLapRegisteredException;

import java.util.List;

@Component
public class FastestLapBO {

    @Autowired
    private FastestLapRepository repo;

    @Autowired
    private RaceRepository raceRepo;

    public FastestLap insert(Long raceId, FastestLap fastestLap) {
        Race race = raceRepo.getOne(raceId);
        fastestLap.setRace(race);
        return repo.save(fastestLap);
    }

    public FastestLap update(Long fastestLapId, FastestLap updatedFastestLap) {
        updatedFastestLap.setId(fastestLapId);
        return repo.saveAndFlush(updatedFastestLap);
    }
}
