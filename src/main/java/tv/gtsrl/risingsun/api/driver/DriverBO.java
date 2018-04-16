package tv.gtsrl.risingsun.api.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DriverBO {

    @Autowired
    private DriverRepository driverRepo;

    @Autowired
    private DriverGtsApiRestTemplate driverGtsApiRestTemplate;

    public Object addDriver(Integer driverGtsId) throws IOException {
        return driverRepo.save(driverGtsApiRestTemplate.getDriverGtsProfileData(driverGtsId));
    }
}
