package com.eliud.store.api.mappers;
import com.eliud.store.api.db.entities.Price;
import com.eliud.store.api.models.PriceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceDTO priceToPriceDTO(Price price);
}
