package com.eliud.store.api.services;

import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.db.repositories.PriceRepository;
import com.eliud.store.api.mappers.PriceMapper;
import com.eliud.store.api.models.PriceDTO;
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

    @Mock
    private PriceMapper priceMapper;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    public void testGetPrices_Success() {
        Long brandId = 1L;
        Date startDate = new Date();
        Long productId = 2L;

        Price price1 = new Price();

        Price price2 = new Price();

        when(priceRepository.findByBrandIdAndStartDateAndProductId(anyLong(), any(Date.class), anyLong()))
                .thenReturn(Arrays.asList(price1, price2));

        when(priceMapper.priceToPriceDTO(any(Price.class))).thenReturn(new PriceDTO());

        List<PriceDTO> result = priceService.getPrices(brandId, startDate, productId);

        verify(priceRepository, times(1)).findByBrandIdAndStartDateAndProductId(eq(brandId), eq(startDate), eq(productId));

        verify(priceMapper, times(2)).priceToPriceDTO(any(Price.class));
    }

    @Test
    public void testGetPrices_EmptyList() {
        Long brandId = 1L;
        Date startDate = new Date();
        Long productId = 2L;

        when(priceRepository.findByBrandIdAndStartDateAndProductId(anyLong(), any(Date.class), anyLong()))
                .thenReturn(Arrays.asList());

        try {
            priceService.getPrices(brandId, startDate, productId);
        } catch (ResponseStatusException e) {
            assert (e.getStatusCode().value() == 204);
        }

        verify(priceRepository, times(1)).findByBrandIdAndStartDateAndProductId(eq(brandId), eq(startDate), eq(productId));

        verify(priceMapper, never()).priceToPriceDTO(any(Price.class));
    }
}