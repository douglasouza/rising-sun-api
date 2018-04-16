package tv.gtsrl.risingsun.api.qualifyingresult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rising-sun/qualifying-result")
public class QualifyingResultRestController {

    @Autowired
    private QualifyingResultRepository qualifyingResultRepo;

    @RequestMapping(method = RequestMethod.POST)
    public Object add(@RequestBody QualifyingResult qualifyingResult) {
        return qualifyingResultRepo.save(qualifyingResult);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        return qualifyingResultRepo.findAll();
    }

}