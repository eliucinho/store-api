package com.eliud.store.api.services;

import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.db.repositories.PriceRepository;
import com.eliud.store.api.models.PriceRequest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class PriceServiceTest extends PriceServiceTestConfig {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    public void testGetPrices_Success() {
        Long brandId = 1L;
        String startDate = "2024-01-14 21:00:00";
        Long productId = 2L;

        Price price1 = new Price();

        Price price2 = new Price();

        when(priceRepository.findByBrandIdAndStartDateAndProductId(anyLong(), any(Date.class), anyLong()))
                .thenReturn(Arrays.asList(price1, price2));


        List<Price> result = priceService.getPrices(brandId, startDate, productId);

        verify(priceRepository, times(1)).findByBrandIdAndStartDateAndProductId(eq(brandId), any(), eq(productId));

    }

    @Test
    public void testGetPrices_EmptyList() {
        Long brandId = 1L;
        String startDate = "2024-01-14 21:00:00";
        Long productId = 2L;

        when(priceRepository.findByBrandIdAndStartDateAndProductId(anyLong(), any(Date.class), anyLong()))
                .thenReturn(Arrays.asList());

        try {
            priceService.getPrices(brandId, startDate, productId);
        } catch (ResponseStatusException e) {
            assert (e.getStatus().value() == 204);
        }

        verify(priceRepository, times(1)).findByBrandIdAndStartDateAndProductId(eq(brandId), any(), eq(productId));
    }
}