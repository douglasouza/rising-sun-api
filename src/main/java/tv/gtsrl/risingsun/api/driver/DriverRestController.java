package tv.gtsrl.risingsun.api.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/rising-sun/driver")
public class DriverRestController {

    //private static final Logger = new Logger(DriverRestController);

    @Autowired
    private DriverRepository driverRepo;

    @Autowired
    private DriverBO bo;

    @RequestMapping(method = RequestMethod.POST, path = "/{driverGtsId}")
    public Object add(@PathVariable("driverGtsId") Integer driverGtsId) {
        try {
            return bo.addDriver(driverGtsId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return driverRepo.findAll();
    }

}