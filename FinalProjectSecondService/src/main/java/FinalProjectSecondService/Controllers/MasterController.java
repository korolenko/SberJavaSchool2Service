package FinalProjectSecondService.Controllers;


import FinalProjectSecondService.DTO.MasterDTO;
import FinalProjectSecondService.Entities.MasterEntity;
import FinalProjectSecondService.Services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@RestController
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @GetMapping("/{id}")
    @ResponseBody
    public MasterEntity get(@PathVariable Long id){
        return masterService.findById(id);
    }

    @PostMapping("")
    @ResponseBody
    public MasterEntity create(@RequestBody MasterDTO masterDTO){
        return masterService.create(masterDTO);
    }

    @GetMapping("/free")
    @ResponseBody
    public Map<String, String> findFreeMaster(){
        return masterService.getFreeMaster();
    }

    @PutMapping("")
    @ResponseBody
    public MasterEntity update(@RequestBody MasterDTO masterDTO){
        return  masterService.update(masterDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        masterService.delete(id);
    }
}
