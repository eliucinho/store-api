package com.eliud.store.api.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {
    private Long productId;
    private Long brandId;
    private Integer priceList;
    private Date startDate;
    private Date endDate;
    private Double finalPrice;
    private String currency;
}
