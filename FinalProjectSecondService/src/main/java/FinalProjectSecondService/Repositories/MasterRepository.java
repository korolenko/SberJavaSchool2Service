package FinalProjectSecondService.Repositories;

import FinalProjectSecondService.Entities.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MasterRepository extends JpaRepository<MasterEntity, Long> {
    @Query(value="select cast(m.id as VARCHAR(20)) as \"id\", m.mastername\n" +
            " from \"order\".master m\n" +
            "where buzy is false\n" +
            "order by id\n" +
            "limit 1", nativeQuery = true)
    public Map<String,String> getFreeMaster();
}
