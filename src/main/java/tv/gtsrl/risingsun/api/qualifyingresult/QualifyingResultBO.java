package tv.gtsrl.risingsun.api.qualifyingresult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tv.gtsrl.risingsun.api.raceday.RaceDay;
import tv.gtsrl.risingsun.api.raceday.RaceDayRepository;

@Component
public class QualifyingResultBO {

    @Autowired
    private QualifyingResultRepository repo;

    @Autowired
    private RaceDayRepository raceDayRepo;

    public QualifyingResult insert(Long raceDayId, QualifyingResult qualifyingResult) {
        RaceDay raceDay = raceDayRepo.getOne(raceDayId);
        qualifyingResult.setRaceDay(raceDay);
        return repo.save(qualifyingResult);
    }

    public QualifyingResult update(Long qualifyingResultId, QualifyingResult updatedQualifyingResult) {
        updatedQualifyingResult.setId(qualifyingResultId);
        return repo.saveAndFlush(updatedQualifyingResult);
    }
}
