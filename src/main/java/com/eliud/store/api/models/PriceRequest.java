package com.eliud.store.api.models;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceRequest {

    @Schema(description = "ID de la marca", required = true)
    private Long brandId;

    @Schema(description = "Fecha de inicio en formato yyyy-MM-dd HH:mm:ss", example = "2024-01-14 21:00:00", required = true)
    private String startDate;

    @Schema(description = "ID del producto", required = true)
    private Long productId;
}