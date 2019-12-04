package FinalProjectSecondService.Repositories;

import FinalProjectSecondService.Entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("select c.id from ClientEntity c\n" +
            "where c.name = :ClientName")
    public Integer getIdByName(@Param("ClientName")String ClientName);
}
