package com.eliud.store.api.config;
import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.db.repositories.PriceRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import lombok.RequiredArgsConstructor;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final PriceRepository priceRepository;

    @PostConstruct
    public void init() {
        try {
            insertTestData();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void insertTestData() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Price price1 = Price.builder()
                .brandId(1L)
                .startDate(dateFormat.parse("2020-06-14 00:00:00"))
                .endDate(dateFormat.parse("2020-12-31 23:59:59"))
                .priceList(1)
                .productId(35455L)
                .priority(0)
                .price(35.50)
                .curr("EUR")
                .build();

        Price price2 = Price.builder()
                .brandId(1L)
                .startDate(dateFormat.parse("2020-06-14 15:00:00"))
                .endDate(dateFormat.parse("2020-06-14 18:30:00"))
                .priceList(2)
                .productId(35455L)
                .priority(1)
                .price(25.45)
                .curr("EUR")
                .build();

        Price price3 = Price.builder()
                .brandId(1L)
                .startDate(dateFormat.parse("2020-06-15 00:00:00"))
                .endDate(dateFormat.parse("2020-06-15 11:00:00"))
                .priceList(3)
                .productId(35455L)
                .priority(1)
                .price(30.50)
                .curr("EUR")
                .build();

        Price price4 = Price.builder()
                .brandId(1L)
                .startDate(dateFormat.parse("2020-06-15 16:00:00"))
                .endDate(dateFormat.parse("2020-12-31 23:59:59"))
                .priceList(4)
                .productId(35455L)
                .priority(1)
                .price(38.95)
                .curr("EUR")
                .build();
        priceRepository.saveAll(Arrays.asList(price1, price2, price3, price4));

        System.out.println("data loaded");
    }
}
