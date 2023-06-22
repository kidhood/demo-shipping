package com.gangoffive.shippingfast.ShippingFast.service;

import org.springframework.http.ResponseEntity;

public interface ShippingFeeService {
    ResponseEntity<?> calculateShippingFee(double distance);
}
