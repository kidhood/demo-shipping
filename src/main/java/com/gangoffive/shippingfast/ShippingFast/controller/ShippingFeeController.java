package com.gangoffive.shippingfast.ShippingFast.controller;

import com.gangoffive.shippingfast.ShippingFast.service.ShippingFeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("api/v1/shipping-fee")
public class ShippingFeeController {
    private final ShippingFeeService shippingFeeService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000,https://birdstore2nd.vercel.app,https://www.birdland2nd.store,https://admin.birdland2nd.store/,http://localhost:3001", allowedHeaders = "*")
    public ResponseEntity<?> getShippingFee(@RequestParam double distance) {
        
        return shippingFeeService.calculateShippingFee(distance);
    }

}
