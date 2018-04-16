package tv.gtsrl.risingsun.api.carclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long> {
}