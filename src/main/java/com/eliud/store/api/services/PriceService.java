package com.eliud.store.api.services;

import com.eliud.store.api.db.entities.Price;

import java.util.Date;
import java.util.List;

public interface PriceService {
    List<Price> getPrices(Long brandId, String startDate, Long productId);
}
