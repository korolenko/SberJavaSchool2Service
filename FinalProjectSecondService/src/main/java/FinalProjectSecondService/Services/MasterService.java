package FinalProjectSecondService.Services;

import FinalProjectSecondService.DTO.MasterDTO;
import FinalProjectSecondService.Entities.MasterEntity;
import FinalProjectSecondService.Repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public class MasterService {

    @Autowired
    private MasterRepository masterRepository;

    public MasterEntity findById(Long id){
        return masterRepository.getOne(id);
    }

    public MasterEntity create(MasterDTO masterDTO){
        MasterEntity masterEntity = new MasterEntity();
        masterEntity.setMasterName(masterDTO.getMasterName());
        return masterRepository.save(masterEntity);
    }

    public MasterEntity update(MasterDTO masterDTO){
        MasterEntity masterEntity = masterRepository.getOne(masterDTO.getId());
        masterEntity.setMasterName(masterDTO.getMasterName());
        masterEntity.setBuzy(masterDTO.isBuzy());
        masterRepository.findOne()
        return masterRepository.save(masterEntity);
    }

    public Map<String,String> getFreeMaster(){
        return masterRepository.getFreeMaster();
    }
    public void delete(Long id){
        masterRepository.delete(masterRepository.getOne(id));
    }
}
