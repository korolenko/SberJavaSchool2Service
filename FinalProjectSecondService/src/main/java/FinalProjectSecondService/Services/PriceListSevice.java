package FinalProjectSecondService.Services;

import FinalProjectSecondService.DTO.PriceListDto;
import FinalProjectSecondService.Entities.PriceListEntity;
import FinalProjectSecondService.Repositories.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        priceListEntity.setSparepartId(priceListDto.getSparepartId());
        priceListEntity.setPrice(priceListDto.getPrice());
        priceListEntity.setSparepartName(priceListDto.getSparepartName());
        return priceListRepository.save(priceListEntity);
    }

    public PriceListEntity update(PriceListDto priceListDto){
        PriceListEntity priceListEntity = priceListRepository.getOne(priceListDto.getId());
        priceListEntity.setPrice(priceListDto.getPrice());
        priceListEntity.setSparepartId(priceListDto.getSparepartId());
        priceListEntity.setSparepartName(priceListDto.getSparepartName());
        return  priceListRepository.save(priceListEntity);
    }

    public Double getPrice(List<Long> ids) {
        //TODO : запрос к первому сервису.
        return priceListRepository.findAllById(ids).stream()
                .map(PriceListEntity::getPrice)
                .reduce((a,b) -> a + b).orElse(.0);
    }

    public Map<String, String> getSparepartsWithPriceids(List<Long> ids){
        return priceListRepository.findAllById(ids).stream()
                .collect(Collectors.toMap(PriceListEntity::getSparepartName, (o1) -> String.valueOf(o1.getPrice())));
//        return priceListRepository.getSparepartsWithPrice(ids);
    }

    public void delete(Long id){
        priceListRepository.delete(priceListRepository.getOne(id));
    }
}
