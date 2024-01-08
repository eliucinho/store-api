package com.eliud.store.api.controllers;

import static org.junit.jupiter.api.Assertions.*;
import com.eliud.store.api.controllers.PriceController;
import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.models.PriceRequest;
import com.eliud.store.api.services.PriceService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

class PriceControllerTest extends PriceControllerTestConfig{

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    @Test
    void testGetPrices_Success() {
        List<Price> mockPrices = new ArrayList<>();
        Mockito.when(priceService.getPrices(any(), any(), any())).thenReturn(mockPrices);

        PriceRequest priceRequest = new PriceRequest(1L, "2024-01-14 21:00:00", 1L);
        ResponseEntity<List<Price>> response = priceController.getPrices(priceRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPrices, response.getBody());
    }

    @Test
    void testGetPrices_EmptyList() {
        List<Price> mockPrices = new ArrayList<>();
        Mockito.when(priceService.getPrices(any(), any(), any())).thenReturn(mockPrices);

        PriceRequest priceRequest = new PriceRequest(1L, "2024-01-14 21:00:00", 1L);
        ResponseEntity<List<Price>> response = priceController.getPrices(priceRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockPrices, response.getBody());
    }

    @Test
    void testGetPrices_StatusException() {
        Mockito.when(priceService.getPrices(any(), any(), any()))
                .thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Datos no encontrados"));

        PriceRequest priceRequest = new PriceRequest(1L, "2024-01-14 21:00:00", 1L);
        ResponseEntity<List<Price>> response = priceController.getPrices(priceRequest);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testGetPrices_Exception() {
        Mockito.when(priceService.getPrices(any(), any(), any())).thenThrow(new RuntimeException("Error interno"));

        PriceRequest priceRequest = new PriceRequest(1L, "2024-01-14 21:00:00", 1L);
        ResponseEntity<List<Price>> response = priceController.getPrices(priceRequest);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
