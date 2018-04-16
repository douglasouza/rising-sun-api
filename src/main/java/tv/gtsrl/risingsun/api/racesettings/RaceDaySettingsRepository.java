package tv.gtsrl.risingsun.api.racesettings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceDaySettingsRepository extends JpaRepository<RaceDaySettings, Long> {

    RaceDaySettings findByRaceDayId(Long raceDayId);
}