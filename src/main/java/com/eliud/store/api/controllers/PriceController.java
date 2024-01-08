package com.eliud.store.api.controllers;

import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.models.PriceRequest;
import com.eliud.store.api.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;
    @PostMapping("/query-prices")
    public ResponseEntity<List<Price>> getPrices(@RequestBody PriceRequest priceRequest) {
        try {
            List<Price> result = priceService.getPrices(
                    priceRequest.getBrandId(),
                    priceRequest.getStartDate(),
                    priceRequest.getProductId()
            );
            return ResponseEntity.ok(result);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatus()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
