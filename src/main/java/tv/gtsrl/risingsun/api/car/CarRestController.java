package tv.gtsrl.risingsun.api.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/car")
public class CarRestController {

    @Autowired
    private CarRepository carRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody Car car) {
        return carRepo.save(car);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return carRepo.findAll();
    }

}