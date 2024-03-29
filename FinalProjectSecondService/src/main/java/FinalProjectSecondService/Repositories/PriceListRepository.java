package FinalProjectSecondService.Repositories;

import FinalProjectSecondService.Entities.PriceListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface PriceListRepository extends JpaRepository<PriceListEntity, Long> {

    //@Query("select p.sparepartName, p.price from PriceListEntity p\n" +
     //       "where p.sparepartId in (:ids)")
    //public Collection<PriceListEntity> getSparepartsWithPrice(@Param("ids") List<Long> ids);

    @Query(value = "select s.sparepart, cast(p.price as varchar(20)) as \"price\" from \"order\".pricelist p\n" +
            "join catalog.sparepart s \n" +
           "on s.id = p.sparepartid\n" +
            "where s.id in(?1)", nativeQuery = true)
    public Map<String,String> getSparepartsWithPrice(List<Long> ids);
}
