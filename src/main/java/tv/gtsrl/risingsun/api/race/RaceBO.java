package tv.gtsrl.risingsun.api.race;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tv.gtsrl.risingsun.api.raceday.RaceDay;
import tv.gtsrl.risingsun.api.raceday.RaceDayRepository;

@Component
public class RaceBO {

    @Autowired
    private RaceRepository repo;

    @Autowired
    private RaceDayRepository raceDayRepo;

    public Race insertRace(Long raceDayId, Race race) {
        RaceDay raceDay = raceDayRepo.getOne(raceDayId);
        race.setRaceDay(raceDay);
        return repo.save(race);
    }
}
