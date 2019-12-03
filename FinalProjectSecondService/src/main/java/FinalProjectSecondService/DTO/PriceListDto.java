package FinalProjectSecondService.DTO;

import lombok.Data;

@Data
public class PriceListDto {

    private Long id;
    private Long sparepartId;
    private String sparepartName;
    private double price;
}
