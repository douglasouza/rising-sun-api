package tv.gtsrl.risingsun.api.racesettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tv.gtsrl.risingsun.api.raceday.RaceDay;
import tv.gtsrl.risingsun.api.raceday.RaceDayRepository;

@Component
public class RaceDaySettingsBO {

    @Autowired
    private RaceDaySettingsRepository repo;

    @Autowired
    private RaceDayRepository raceDayRepo;

    public RaceDaySettings insert(Long raceId, RaceDaySettings raceDaySettings) {
        RaceDay raceDay = raceDayRepo.getOne(raceId);
        raceDaySettings.setRaceDay(raceDay);
        return repo.save(raceDaySettings);
    }

    public RaceDaySettings update(Long raceDaySettingsId, RaceDaySettings updatedRaceDaySettings) {
        updatedRaceDaySettings.setId(raceDaySettingsId);
        return repo.saveAndFlush(updatedRaceDaySettings);
    }
}
