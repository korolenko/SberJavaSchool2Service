package FinalProjectSecondService.Controllers;

import FinalProjectSecondService.DTO.ClientDTO;
import FinalProjectSecondService.Entities.ClientEntity;
import FinalProjectSecondService.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    @ResponseBody
    public ClientEntity get(@PathVariable Long id){
        return clientService.findById(id);
    }

    @PostMapping("/getidbyname")
    @ResponseBody
    public Integer getIdByName(@RequestBody ClientDTO clientDTO){
        return clientService.getIdByName(clientDTO);
    }

    @PostMapping("")
    @ResponseBody
    public ClientEntity create(@RequestBody ClientDTO clientDTO){
        return clientService.create(clientDTO);
    }

    @PutMapping("")
    @ResponseBody
    public ClientEntity update(@RequestBody ClientDTO clientDTO){
        return clientService.update(clientDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
         clientService.delete(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public Map<Long,String> getAll(){
        return clientService.findAll();
    }
}
