package cybersecu.api.reduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path="/reduction")
public class ReductionController {

    @Autowired
    private ReductionRepository reductionRepository;

    @GetMapping("find-by-percent/{percent}")
    public Set<Reduction> getReductionByPercent(@PathVariable("percent") int percent) {
        return reductionRepository.findByPercent(percent);
    }
}
