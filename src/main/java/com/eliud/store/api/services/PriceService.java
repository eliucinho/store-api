package com.eliud.store.api.services;

import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.models.PriceDTO;

import java.util.Date;
import java.util.List;

public interface PriceService {
    List<Price> getPrices(Long brandId, Date startDate, Long productId);
}
