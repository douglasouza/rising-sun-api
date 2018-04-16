package tv.gtsrl.risingsun.api.racesettings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceSettingsRepository extends JpaRepository<RaceSettings, Long> {
}