package com.eliud.store.api.services;
import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.db.repositories.PriceRepository;
import com.eliud.store.api.mappers.PriceMapper;
import com.eliud.store.api.models.PriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public List<PriceDTO> getPrices(Long brandId, Date startDate, Long productId) {
        List<Price> prices = priceRepository.findByBrandIdAndStartDateAndProductId(brandId, startDate, productId);

        if (prices.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "List is empty");
        }

        return prices.stream()
                .map(priceMapper::priceToPriceDTO)
                .collect(Collectors.toList());
    }
}
