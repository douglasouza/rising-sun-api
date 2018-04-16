package tv.gtsrl.risingsun.api.raceresult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {
}