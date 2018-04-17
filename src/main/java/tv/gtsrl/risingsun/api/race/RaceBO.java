package tv.gtsrl.risingsun.api.race;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tv.gtsrl.risingsun.api.fastestlap.FastestLap;
import tv.gtsrl.risingsun.api.fastestlap.FastestLapRepository;
import tv.gtsrl.risingsun.api.raceday.RaceDay;
import tv.gtsrl.risingsun.api.raceday.RaceDayRepository;
import tv.gtsrl.risingsun.api.raceresult.RaceResult;
import tv.gtsrl.risingsun.api.raceresult.RaceResultRepository;
import tv.gtsrl.risingsun.common.exception.RaceResultsFastestLapRegisteredException;

import java.util.List;

@Component
public class RaceBO {

    @Autowired
    private RaceRepository repo;

    @Autowired
    private RaceDayRepository raceDayRepo;

    @Autowired
    private RaceResultRepository raceResultRepo;

    @Autowired
    private FastestLapRepository fastestLapRepo;

    public Race insert(Long raceDayId, Race race) {
        RaceDay raceDay = raceDayRepo.getOne(raceDayId);
        race.setRaceDay(raceDay);
        return repo.save(race);
    }

    public Race update(Long raceId, Race updatedRace) {
        updatedRace.setId(raceId);
        return repo.saveAndFlush(updatedRace);
    }

    public void delete(Long raceId) {
        List<RaceResult> raceResults = raceResultRepo.findByRaceId(raceId);
        FastestLap fastestLap = fastestLapRepo.findByRaceId(raceId);

        if (!CollectionUtils.isEmpty(raceResults) || fastestLap != null)
            throw new RaceResultsFastestLapRegisteredException();

        repo.deleteById(raceId);
    }
}
