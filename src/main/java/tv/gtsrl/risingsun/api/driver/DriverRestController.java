package tv.gtsrl.risingsun.api.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rising-sun/driver")
public class DriverRestController {

    @Autowired
    private DriverRepository repo;

    @Autowired
    private DriverBO bo;

    @PostMapping(params = "driverGtsId")
    public Object insert(@RequestParam("driverGtsId") Integer driverGtsId) {
        try {
            return bo.insert(driverGtsId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping
    public List<Driver> getAll() {
        return repo.findAll();
    }

}