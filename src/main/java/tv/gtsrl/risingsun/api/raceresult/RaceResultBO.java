package tv.gtsrl.risingsun.api.raceresult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tv.gtsrl.risingsun.api.race.Race;
import tv.gtsrl.risingsun.api.race.RaceRepository;

@Component
public class RaceResultBO {

    @Autowired
    private RaceResultRepository repo;

    @Autowired
    private RaceRepository raceRepo;

    public RaceResult insert(Long raceId, RaceResult raceResult) {
        Race race = raceRepo.getOne(raceId);
        raceResult.setRace(race);
        return repo.save(raceResult);
    }

    public RaceResult update(Long raceResultId, RaceResult updatedRaceResult) {
        updatedRaceResult.setId(raceResultId);
        return repo.saveAndFlush(updatedRaceResult);
    }
}
