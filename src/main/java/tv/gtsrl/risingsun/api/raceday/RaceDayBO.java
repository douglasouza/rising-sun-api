package tv.gtsrl.risingsun.api.raceday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tv.gtsrl.risingsun.api.race.Race;
import tv.gtsrl.risingsun.api.race.RaceRepository;
import tv.gtsrl.risingsun.api.racesettings.RaceDaySettings;
import tv.gtsrl.risingsun.api.racesettings.RaceDaySettingsRepository;
import tv.gtsrl.risingsun.common.exception.RaceQualifyingResultRegisteredException;

import java.util.List;

@Component
public class RaceDayBO {

    @Autowired
    private RaceDayRepository repo;

    @Autowired
    private RaceRepository raceRepo;

    @Autowired
    private RaceDaySettingsRepository raceDaySettingsRepo;

    public RaceDay insert(RaceDay raceDay) {
//        if (raceDay.getDate().before(new Date()))
//            throw new DateBeforeTodayException();

        return repo.save(raceDay);
    }

    public RaceDay update(Long raceDayId, RaceDay updatedRaceDay) {
        updatedRaceDay.setId(raceDayId);
        return repo.saveAndFlush(updatedRaceDay);
    }

    public void delete(Long raceDayId) {
        List<Race> raceDayRaces = raceRepo.findByRaceDayId(raceDayId);
        RaceDaySettings raceDaySettings = raceDaySettingsRepo.findByRaceDayId(raceDayId);

        if (!CollectionUtils.isEmpty(raceDayRaces) || raceDaySettings != null)
            throw new RaceQualifyingResultRegisteredException();

        repo.deleteById(raceDayId);
    }

}
