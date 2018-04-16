package tv.gtsrl.risingsun.api.carclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/car-class")
public class CarClassRestController {

    @Autowired
    private CarClassRepository carClassRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody CarClass carClass) {
        return carClassRepo.save(carClass);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return carClassRepo.findAll();
    }

}