package com.eliud.store.api.db.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PriceId.class)
public class Price implements Serializable {

    @Id
    private Long brandId;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Id
    private Long productId;

    private Date endDate;
    private Integer priceList;
    private Integer priority;
    private Double price;
    private String curr;
}
