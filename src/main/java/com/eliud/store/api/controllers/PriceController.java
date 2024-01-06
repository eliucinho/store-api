package com.eliud.store.api.controllers;

import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.models.PriceDTO;
import com.eliud.store.api.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/consulta-precios")
    public ResponseEntity<List<PriceDTO>> getPrices(
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
            @RequestParam Long productId) {
        try {
            List<PriceDTO> result = priceService.getPrices(brandId, startDate, productId);
            return ResponseEntity.ok(result);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}