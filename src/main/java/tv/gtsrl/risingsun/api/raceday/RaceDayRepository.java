package tv.gtsrl.risingsun.api.raceday;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceDayRepository extends JpaRepository<RaceDay, Long> {
}