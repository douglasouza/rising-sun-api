package tv.gtsrl.risingsun.api.fastestlap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FastestLapRepository extends JpaRepository<FastestLap, Long> {
}