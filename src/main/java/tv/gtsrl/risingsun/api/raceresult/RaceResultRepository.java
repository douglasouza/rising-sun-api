package tv.gtsrl.risingsun.api.raceresult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {

    List<RaceResult> findByRaceId(Long raceId);
}