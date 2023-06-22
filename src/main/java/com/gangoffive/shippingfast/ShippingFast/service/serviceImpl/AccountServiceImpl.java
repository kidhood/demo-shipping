package com.gangoffive.shippingfast.ShippingFast.service.serviceImpl;

import com.gangoffive.shippingfast.ShippingFast.entity.Account;
import com.gangoffive.shippingfast.ShippingFast.repository.AccountRepository;
import com.gangoffive.shippingfast.ShippingFast.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Override
    public String authenticate(String username, String password) {
        Optional<Account> account = accountRepository.findByUsername(username);
        if (account.isPresent()) {
            if (account.get().getPassword().equals(password)) {
                return "login_success";
            } else {
                return "login_fail";
            }
        } else {
            return "login_fail";
        }
    }
}
