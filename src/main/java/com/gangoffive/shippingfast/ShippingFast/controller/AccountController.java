package com.gangoffive.shippingfast.ShippingFast.controller;

import com.gangoffive.shippingfast.ShippingFast.dto.AuthenticateRequest;
import com.gangoffive.shippingfast.ShippingFast.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("api/v1")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000,https://birdstore2nd.vercel.app,https://www.birdland2nd.store,https://admin.birdland2nd.store/,http://localhost:3001", allowedHeaders = "*")
    public String authenticate(@RequestBody AuthenticateRequest authenticateRequest) {
        return accountService.authenticate(authenticateRequest.getUsername(), authenticateRequest.getPassword());
        
    }
}
