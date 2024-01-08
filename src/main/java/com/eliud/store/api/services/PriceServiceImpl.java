package com.eliud.store.api.services;
import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.db.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;


    @Override
    public List<Price> getPrices(Long brandId, String startDate, Long productId) {
        Date startDateConverted=convertToDate(startDate);
        List<Price> prices = priceRepository.findByBrandIdAndStartDateAndProductId(brandId,startDateConverted, productId);

        if (prices.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "List is empty");
        }

        return prices;
    }
    private Date convertToDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Format is not valid", e);
        }
    }
}
