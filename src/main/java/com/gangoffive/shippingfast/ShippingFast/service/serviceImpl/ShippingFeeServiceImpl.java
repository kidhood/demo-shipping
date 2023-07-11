package com.gangoffive.shippingfast.ShippingFast.service.serviceImpl;

import com.gangoffive.shippingfast.ShippingFast.dto.ShippingFeeResponseDto;
import com.gangoffive.shippingfast.ShippingFast.entity.ShippingFee;
import com.gangoffive.shippingfast.ShippingFast.repository.ShippingFeeRepository;
import com.gangoffive.shippingfast.ShippingFast.service.ShippingFeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ShippingFeeServiceImpl implements ShippingFeeService {
    private final ShippingFeeRepository shippingFeeRepository;
    @Override
    public ResponseEntity<?> calculateShippingFee(double distance) {
        if (distance > 0) {
            Optional<ShippingFee> shippingFeeByDistanceRange = shippingFeeRepository.findShippingFeeByDistanceRange(distance);

            double feeShip = shippingFeeByDistanceRange.get().getFee() * distance;
            ShippingFeeResponseDto shippingFeeResponseDto = ShippingFeeResponseDto.builder()
                    .priceEachKm(shippingFeeByDistanceRange.get().getFee())
                    .shippingFee(Math.round(feeShip * 100.0) / 100.0)
                    .build();
            return ResponseEntity.ok(shippingFeeResponseDto);
        } else if (distance == 0) {
            Optional<ShippingFee> shippingFeeByDistanceRange = shippingFeeRepository.findShippingFeeByDistanceRange(distance);

            ShippingFeeResponseDto shippingFeeResponseDto = ShippingFeeResponseDto.builder()
                    .priceEachKm(shippingFeeByDistanceRange.get().getFee())
                    .shippingFee(shippingFeeByDistanceRange.get().getFee())
                    .build();
            return ResponseEntity.ok(shippingFeeResponseDto);
        } else {
            return new ResponseEntity<>("Not support this locate.", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
