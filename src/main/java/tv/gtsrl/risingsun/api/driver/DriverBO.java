package tv.gtsrl.risingsun.api.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DriverBO {

    @Autowired
    private DriverRepository repo;

    @Autowired
    private DriverGtsApiRestTemplate driverGtsApiRestTemplate;

    public Driver insert(Integer driverGtsId) throws IOException {
        return repo.save(driverGtsApiRestTemplate.getDriverGtsProfileData(driverGtsId));
    }
}
