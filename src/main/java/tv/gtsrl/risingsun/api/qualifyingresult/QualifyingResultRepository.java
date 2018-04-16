package tv.gtsrl.risingsun.api.qualifyingresult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualifyingResultRepository extends JpaRepository<QualifyingResult, Long> {
}