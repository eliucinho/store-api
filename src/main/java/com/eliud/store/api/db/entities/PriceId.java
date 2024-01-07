package com.eliud.store.api.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceId implements Serializable {

    private Long brandId;
    private Date startDate;
    private Long productId;

}