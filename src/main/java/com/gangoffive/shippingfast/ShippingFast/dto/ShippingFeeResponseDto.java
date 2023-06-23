package com.gangoffive.shippingfast.ShippingFast.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShippingFeeResponseDto {
    private double priceEachKm;
    private double shippingFee;
}
