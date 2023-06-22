package com.gangoffive.shippingfast.ShippingFast.service.serviceImpl;

import com.gangoffive.shippingfast.ShippingFast.repository.ShippingFeeRepository;
import com.gangoffive.shippingfast.ShippingFast.service.ShippingFeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShippingFeeServiceImpl implements ShippingFeeService {
    private final ShippingFeeRepository shippingFeeRepository;
    @Override
    public ResponseEntity<?> calculateShippingFee(double distance) {
        if (distance > 0) {
            Optional<com.gangoffive.shippingfast.ShippingFast.entity.ShippingFee> shippingFeeByDistanceRange = shippingFeeRepository.findShippingFeeByDistanceRange(distance);
            double feeShip = shippingFeeByDistanceRange.get().getFee() * distance;
            return ResponseEntity.ok(Math.round(feeShip * 100.0) / 100.0);
        } else {
            return ResponseEntity.badRequest().body("Distance less than 0");
        }
    }
}
