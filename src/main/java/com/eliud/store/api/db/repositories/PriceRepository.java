package com.eliud.store.api.db.repositories;

import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.db.entities.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface PriceRepository extends JpaRepository<Price, PriceId> {

    List<Price> findByBrandIdAndStartDateAndProductId(Long brandId, Date startDate, Long productId);
}