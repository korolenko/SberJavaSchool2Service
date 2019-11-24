package FinalProjectSecondService.Services;

import FinalProjectSecondService.DTO.PriceListDto;
import FinalProjectSecondService.Entities.PriceListEntity;
import FinalProjectSecondService.Repositories.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PriceListSevice {

    @Autowired
    private PriceListRepository priceListRepository;

    public PriceListEntity findById(Long id){
        return priceListRepository.getOne(id);
    }

    public PriceListEntity create(PriceListDto priceListDto){
        PriceListEntity priceListEntity = new PriceListEntity();
        priceListEntity.setSparePart(priceListDto.getSparePart());
        priceListEntity.setPrice(priceListDto.getPrice());
        return priceListRepository.save(priceListEntity);
    }

    public PriceListEntity update(PriceListDto priceListDto){
        PriceListEntity priceListEntity = priceListRepository.getOne(priceListDto.getId());
        priceListEntity.setPrice(priceListDto.getPrice());
        priceListEntity.setSparePart(priceListDto.getSparePart());
        return  priceListRepository.save(priceListEntity);
    }

    public Double getPrice(List<Long> ids) {
        //TODO : запрос к первому сервису.
        return priceListRepository.findAllById(ids).stream()
                .map(PriceListEntity::getPrice)
                .reduce((a,b) -> a + b).orElse(.0);
    }

    public void delete(Long id){
        priceListRepository.delete(priceListRepository.getOne(id));
    }
}
