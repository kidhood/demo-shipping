package com.gangoffive.shippingfast.ShippingFast.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AuthenticateRequest {
    private String username;
    private String password;
}
