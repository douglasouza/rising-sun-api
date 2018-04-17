package tv.gtsrl.risingsun.api.season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rising-sun/season")
public class SeasonRestController {

    @Autowired
    private SeasonRepository seasonRepo;

    @PostMapping
    public Season insert(@RequestBody Season season) {
        return seasonRepo.save(season);
    }

    @GetMapping
    public List<Season> getAll() {
        return seasonRepo.findAll();
    }

}