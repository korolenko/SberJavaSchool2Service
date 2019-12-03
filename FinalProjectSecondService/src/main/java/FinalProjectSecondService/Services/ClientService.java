package FinalProjectSecondService.Services;

import FinalProjectSecondService.DTO.ClientDTO;
import FinalProjectSecondService.Entities.ClientEntity;
import FinalProjectSecondService.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Transactional
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity findById(Long id){
        return clientRepository.getOne(id);
    }

    public Map<Long,String> findAll(){
        return clientRepository.findAll().stream()
                .collect(Collectors.toMap(ClientEntity::getId,ClientEntity::getName));
    }

    public ClientEntity create(ClientDTO clientDTO){
        return clientRepository.save(new ClientEntity().setName(clientDTO.getName()));
    }

    public ClientEntity update(ClientDTO clientDTO){
        ClientEntity clientEntity = clientRepository.getOne(clientDTO.getId());
        clientEntity.setName(clientDTO.getName());
        return clientRepository.save(clientEntity);
    }

    public void delete(Long id){
        clientRepository.delete(clientRepository.getOne(id));
    }
}
