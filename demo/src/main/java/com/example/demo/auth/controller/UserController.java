package com.example.demo.auth.controller;



import com.example.demo.auth.dto.LoginBody;
import com.example.demo.auth.dto.RegisterBody;
import com.example.demo.auth.dto.Res;
import com.example.demo.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {


    private final AuthenticationService authenticationService;

    @PostMapping("/api/auth/register/")
    public Res createUser(@RequestBody RegisterBody registerBody){
        return authenticationService.signup(registerBody);
    }

    @PostMapping("/api/auth/signin")
    public Res signIn(@RequestBody LoginBody loginBody){
        System.out.println(loginBody);
        return authenticationService.signin(loginBody);
    }



}
