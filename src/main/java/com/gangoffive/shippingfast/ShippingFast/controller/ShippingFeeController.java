package com.gangoffive.shippingfast.ShippingFast.controller;

import com.gangoffive.shippingfast.ShippingFast.service.ShippingFeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("api/v1/shipping-fee")
public class ShippingFeeController {
    private final ShippingFeeService shippingFeeService;

    @GetMapping
    public ResponseEntity<?> getShippingFee(@RequestParam double distance) {
        return shippingFeeService.calculateShippingFee(distance);
    }

}
