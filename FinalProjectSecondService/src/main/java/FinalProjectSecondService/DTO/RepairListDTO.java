package FinalProjectSecondService.DTO;


import lombok.Data;

import java.util.UUID;

@Data
public class RepairListDTO {

    private Long id;
    private UUID orderUUID;
    private Long pricelistId;
}
