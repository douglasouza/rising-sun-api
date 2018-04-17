package tv.gtsrl.risingsun.api.qualifyingresult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rising-sun/raceDay/{raceDayId}/qualifying-result")
public class QualifyingResultRestController {

    @Autowired
    private QualifyingResultRepository repo;

    @Autowired
    private QualifyingResultBO bo;

    @PostMapping
    public QualifyingResult insert(@PathVariable("raceDayId") Long raceDayId, @RequestBody QualifyingResult qualifyingResult) {
        return bo.insert(raceDayId, qualifyingResult);
    }

    @PutMapping
    public QualifyingResult update(@PathVariable("qualifyingResultId") Long qualifyingResultId, @RequestBody QualifyingResult updatedQualifyingResult) {
        return bo.update(qualifyingResultId, updatedQualifyingResult);
    }

    @DeleteMapping(path = "/{qualifyingResultId}")
    public void delete(@PathVariable("qualifyingResultId") Long qualifyingResultId) {
        repo.deleteById(qualifyingResultId);
    }

    @GetMapping
    public List<QualifyingResult> getAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{qualifyingResultId}")
    public QualifyingResult getOne(@PathVariable("qualifyingResultId") Long qualifyingResultId) {
        return repo.getOne(qualifyingResultId);
    }

}