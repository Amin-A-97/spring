package com.example.demo.auth.service;

import com.example.demo.auth.dto.LoginBody;
import com.example.demo.auth.dto.RegisterBody;
import com.example.demo.auth.dto.Res;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    Res signup(RegisterBody registerBody);
    Res signin(LoginBody loginBody);
    String chnagePassword();
    String recoveryPassword();
}
